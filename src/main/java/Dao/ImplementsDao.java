package Dao;

import java.util.HashMap;
import java.util.List;

import org.Util.Author;
import org.Util.AuthorMessage;
import org.Util.Reply;
import org.Util.Topic;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.TopicVo;
@Repository
public class ImplementsDao implements BbsDao{
	
	@Autowired
	SqlSessionTemplate testDao;
	@Override
	public List<Topic> TopicFormDao()  {
		
		List<Topic> list= testDao.selectList("TopicFormDao");
		return list;
	}
	

	@Override
	public List<Reply> DetailDao(Integer id) {
		List<Reply> list=testDao.selectList("DetailDao", id);
		System.out.println(list.size());
		return list;
	}


	@Override
	public AuthorMessage AuthorDao(String author) {
		AuthorMessage message=testDao.selectOne("AuthorDao", author);
		System.out.println(message.getTelphone());
		return message;
	}


	@Override
	public Author loginDao(Author author) {
		Author login=testDao.selectOne("loginDao",author);
		return login;
	}


	@Override
	public int registerDao(Author author) {
		int register=testDao.insert("registerDao",author);
		return register;
	}


	@Override
	public List<TopicVo> SearchDao(TopicVo topic) {
	List<TopicVo> list=testDao.selectList("SearchDao",topic);
		return list;
	}


	@Override
	public int deleteTopicDao(String[] ids) {
		int delete=testDao.delete("deleteTopicDao", ids);
		return delete;
	}


	@Override
	public int updateHeader(String header,String name) {
		int update=testDao.update("updateHeader", new Object[]{header,name});
		return update;
	}


	@Override
	public int updateFormDao(AuthorMessage author) {
		int update=testDao.update("updateFormDao", author);
		return 0;
	}


	/*



	@Override
	public Author loginDao(String name, String pass) {
		String sql="select bbs_name,bbs_pass from bbsuser where bbs_name=? and bbs_pass=? ";
		Author author=null;
		List<Author> list=template.query(sql, new Object[]{name,pass},new RowMapper<Author>(){

			@Override
			public Author mapRow(ResultSet rs, int arg1) throws SQLException {
				Author author=new Author();
				author.setName(rs.getString("bbs_name"));
				author.setPass(rs.getString("bbs_pass"));
				return author;
			}
			
		});
		if(list.size()>0){
			author=list.get(0);
		}
		return author;
		}
		@Override
	public int registerDao(String name, String pass) {
		int register=testDao.insert(name, pass);
		return register;
	}*/
	
public static void main(String arg0[]){
	StringBuffer sb1=new StringBuffer("String");
	StringBuffer sb2=new StringBuffer("String");
	if(!sb1.equals(sb2)){
	System.out.println("false"); 
	}else{
	System.out.println("true");
	}

}


	
}
