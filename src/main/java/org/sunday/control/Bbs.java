package org.sunday.control;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Service.BbsService;
import org.Util.Author;
import org.Util.AuthorMessage;
import org.Util.Reply;
import org.Util.Topic;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import vo.TopicVo;

@Controller
@RequestMapping("/user")
public class Bbs {
	Logger loger=LoggerFactory.getLogger(Bbs.class);
	
	
	@Autowired
	BbsService service;
	@RequestMapping("/topic")	
	public String topic(Model model){
		List<Topic> list=service.TopicFormService();
		model.addAttribute("list",list);
		return "topic";
	}
	@RequestMapping("/dologer")
	public String news(String name){
	loger.debug("loger,段闪闪王八蛋");
		return "mylist";
	}
	@RequestMapping("/reply")
	public	 String detail( Model model,Integer id,HttpSession session) throws SQLException{
		
		List<Reply> list=service.ReplyFormService(id);
	session.setAttribute("title", list.get(0).getTopic().getTitle().toString());
	session.setAttribute("author", list.get(0).getTopic().getAuthor().toString());
	session.setAttribute("header", list.get(0).getTopic().getHeader().toString());
	System.out.println( list.get(0).getTopic().getHeader().toString());
		model.addAttribute("list",list);
		return "reply";
	}
	
	@RequestMapping("/loginer")
	public String realLogin(){
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	@ResponseBody
	public Object login(Model model,Author author){
		System.out.println(author.getName());
		Author login=service.loginService(author);
	
		HashMap<String,Object> map=new HashMap<String,Object>();
		if(login!=null){
		map.put("code", 200);
		map.put("message", "登录成功");
		
		}else{
			map.put("code", 250);
			map.put("message", "登录失败");
		}
		return map;
	}
	
	@RequestMapping("/author")
	public String authorMessage( Model model,String  author) throws SQLException{
		
		AuthorMessage message=service.authorMessageService(author);
		System.out.println(message.getSex());
		model.addAttribute("message",message);
		return "author";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	@ResponseBody
	public Object register(Model model,Author author,String Validate,HttpSession session){
		
		System.out.println(Validate);
		String v=(String)session.getAttribute("SMSCode");
		System.out.println(v);
		HashMap<String,Object> map=new HashMap<String,Object>();
		if(!Validate.equals("v")){
			map.put("code", 222);
			map.put("message", "验证码错误");
			System.out.println("haha");
		}else {
			Author login=service.loginService(author);
			if(login!=null){
			
			System.out.println(login);
		
			
			map.put("code", 250);
			map.put("message", "注册失败,该用户已经注册过，请直接登录");
			
		}else{
			int register=service.registerService(author);
			System.out.println(register);
				
			map.put("code", 200);
			map.put("message", "注册成功");
			
		}
		
	
		}
		return map;
	}
	@RequestMapping(value="/sendmessage",method=RequestMethod.GET)
	@ResponseBody
	public void sendSMS(Model model,String telphone,HttpSession session){
		System.out.println(telphone);
		 String url ="http://sms.106jiekou.com/utf8/sms.aspx";
		 String account= "291580817";
		 String psw="YW020230";
		 SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  
		 String code = String.valueOf(Math.round(Math.random()*9999));
		 session.setAttribute("SMSCode", code);
		 String content = "您的订单编码："+code+"。如需帮助请联系客服。";
	     String urlNameString = url + "?account="+account+"&password="+psw+"&mobile="+telphone+"&content="+content ;
	     System.out.println(urlNameString);
	    String  result=null;
	     URL url1;
		try {
			url1 = new URL(urlNameString);
			  HttpURLConnection connection = (HttpURLConnection) url1.openConnection();  
		        connection.setDoInput(true);  
		        connection.setDoOutput(true); 
		        connection.setRequestMethod("GET");
		        connection.connect(); 
		  
				 InputStreamReader  bis = new InputStreamReader(connection.getInputStream(),"gb2312");  
			        int c = 0;  
			        while((c = bis.read()) != -1){  
			            result = result + (char)c; 
			        }
		           System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      
	      
	        }  
	@RequestMapping(value="/searchTopic",method=RequestMethod.GET)
	public String SearchTopic(TopicVo topic,Model model){
		List<TopicVo> list=service.SearchService(topic);
		model.addAttribute("list",list);
		model.addAttribute("topic",topic);
		
		return "topicsearch";
	}
	@RequestMapping(value="/deleteTopic",method=RequestMethod.GET)
	public String DeleteTopic(String[] ids,Model model){
		System.out.println(ids);
		int delete=service.deleteTopicService(ids);
		List list=service.TopicFormService();
		
		model.addAttribute("delete",delete);
		model.addAttribute("list",list);
		return "topic";
	}
	@RequestMapping(method=RequestMethod.GET)
    public String upload(){
        return "fileupload";
    }
    
    @RequestMapping(value="/uploadHeader",method=RequestMethod.POST)
    public String uploadPost(@Param("name") String name,AuthorMessage author,Model model, MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException{
    	System.out.println(name);
    	 String pathRoot = request.getSession().getServletContext().getRealPath("");  
    	 System.out.println(pathRoot);
         String path="";  
         if(!file.isEmpty()){  
             //生成uuid作为文件名称  
             String uuid = UUID.randomUUID().toString().replaceAll("-","");  
             //获得文件类型（可以判断如果不是图片，禁止上传）  
             String contentType=file.getContentType();  
             //获得文件后缀名称  
             String imageName=contentType.substring(contentType.indexOf("/")+1);  
             System.out.println(imageName);
             path=uuid+"."+imageName; 
             System.out.println(path);  
             System.out.println("hah");
            
             file.transferTo(new File(pathRoot+path));  
         }  
        
         request.setAttribute("imagesPath", path); 
         System.out.println(path);
     
         int update=service.updateHeader(path,name);
  	      model.addAttribute("header", update);
         return "author";  
     }  
     //因为我的JSP在WEB-INF目录下面，浏览器无法直接访问  
   
    @RequestMapping(value="/updateAuthor", method=RequestMethod.GET)
    public String updateHeader(AuthorMessage author,Model model,HttpServletRequest request){
    	int update=service.updateForm(author);
    	model.addAttribute("update", update);
    	AuthorMessage message=service.authorMessageService(author.getName());
		System.out.println(message.getSex());
		model.addAttribute("message",message);   
    	      return "author";
    }

	
	
}
