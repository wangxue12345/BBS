<!DOCTYPE html>
<html>
<head>
<title>Trendy Tab Login Form Flat Responsive Widget Template </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="/practice/static/logincss/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- js -->
<style type="text/css">
#telValidate{

}
</style>
<script src="/practice/static/loginjs/jquery.min.js"></script>
<script src="/practice/static/loginjs/easyResponsiveTabs.js" type="text/javascript"></script>
<!-- //js -->
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>Trendy Tab Login Form</h1>
		<div class="login-form">
			<div class="sap_tabs w3ls-tabs">
				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>Login</span></li> 
						<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><label>/</label><span>Sign up</span></li>
					</ul>	
					<div class="clear"> </div>
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
							<div class="login-agileits-top"> 
								<form  method="post" id="login">
									<p>User Name </p>
									<input type="text" name="name" required=""/>
									<p>Password</p>
									<input type="password" name="pass" required=""/>	 
									<input type="checkbox" id="brand" value="">
									<label for="brand"><span></span> Remember me ?</label> 
									<input type="text" style="background-color:blue; font-size:20px; font-color:white;text-align:center" onClick="login()" value="LOGIN"  id="loginsubmit"  >								</form>  
								</form>  
							</div>
							<div class="login-agileits-bottom"> 
								<p><a href="#">Forgot password?</a></p>
							</div> 
						</div> 
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
							<div class="login-agileits-top sign-up"> 
								<form  method="post" id="register">
									<p>User Name </p>
									<input type="text" name="name" required=""/>
									<p>Password</p>
									<input type="password" name="pass" required=""/>	
										<p>TelPhone</p>
								
								<span> <input id="btnSendCode" type="button" value="发送验证码" onclick="SendValidationCode()" style="width: 100px;height:50px;float:right" /></span>
									<input id="telphone" type="text" name="telphone" required="" style="width:150px"> 
								
								<br/>
								
									<input id="Validate" type="text" name="Validate" placeholder="验证码" required="" style="width:150px ">
									<input type="checkbox" id="brand" value="">
									<label for="brand"><span></span> Remember me ?</label> 
									<input type="text" style="background-color:blue; font-size:20px; font-color:white;text-align:center" onClick="register()" value="REGISTER"  id="registersubmit"  >								</form>  
								</form>  
							</div>
						</div>
					</div>							
				</div>	 
			</div> 
			
		</div>	
	</div>	
	<!-- //main -->
	<script type="text/javascript">
				$(document).ready(function () {
					$('#horizontalTab').easyResponsiveTabs({
						type: 'default', //Types: default, vertical, accordion           
						width: 'auto', //auto or any width like 600px
						fit: true   // 100% fit in a container
					});
				});

 function login(){
	  var data=$('#login').serialize();
		//序列化获得表单数据
		var submitData=decodeURIComponent(data,true);
		
		//submitData是解码后的表单数据，结果同上
		$.ajax({
		    url:'/practice/user/login',
		    type:'GET',
		    data:submitData,
		    cache:false,//false是不缓存，true为缓存
		    async:true,//true为异步，false为同步
		    dataType:'json',
		    success:function(result){

				alert(result);
		    	 if(result.code==200){
		    		   alert("chenggong");
		    		   window.location.href="/practice/user/topic";
		    	}else{
		    		
		    		alert("注册失败");
		    	}
				
		    	
		    }
		});
}
function register(){
	  var data=$('#register').serialize();
		//序列化获得表单数据
		var submitData=decodeURIComponent(data,true);
		alert(submitData);
		//submitData是解码后的表单数据，结果同上
		$.ajax({
		    url:'/practice/user/register',
		    type:'GET',
		    data:submitData,
		    cache:false,//false是不缓存，true为缓存
		    async:true,//true为异步，false为同步
		    dataType:'json',
		    success:function(result){
		    	
		    	alert(result.code);
		    	 if(result.code==200){
		    		   alert(result.message);
		    		   window.location.href="/practice/user/topic";
		    	}else if(result.code=222){
		    		
		    		alert(result.message);
		    	}else{
		    		alert(result.message);
		    		  window.location.href="/practice/user/loginer";
		    	}
		    }
		});
}
function SendValidationCode(){
		var telphone = $("#telphone").val();
		//验证手机号格式
		alert(telphone)
		
			
			alert(telphone)
		
			
			$.ajax({  
				type: "GET",  
				url:'/practice/user/sendmessage',  
				data:{'telphone':telphone},  
				async: false,  
				success: function(data) {  
				
				}  
			});
		
		
	}

			</script>
	<!-- copyright -->
	<div class="copyright">
		<p> © 2016 Trendy Tab Login Form . All rights reserved | Design by sucaihuo.com</p>
	</div>
	<!-- //copyright --> 
</body>
</html>