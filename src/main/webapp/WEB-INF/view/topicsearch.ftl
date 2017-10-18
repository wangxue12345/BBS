<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>《豆福传》</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/practice/static/css/bootstrap.min.css" rel="stylesheet">
	</head>

	<style type="text/css">
		li a {
			font-size: 20px;
			margin-top: 5px;
		}
		
		th {
			text-align: center;
		}
	</style>

	<body>
				<div class="col-lg-10">
					<div class="text-center" style="margin-right: 30px;">
					
						<h1> 
				
						
						</h1>
						<form id="searchTopic" action="/practice/user/searchTopic" method="get">
						<table border="1">
						<tr>
						<th>编号<input id="" name="id" value="${Request.topic.id}"></th>
						<th>标题<input id="" name="title" value="${Request.topic.title}"></th>
						<th>时间<input id="" name="createtime" value="${Request.topic.createtime}"></th>
						<th>发帖人<input id="" name="author" value="${Request.topic.author}"></th>
						<th><select name="order" >
						<option value="">请选择</option>
						<option value="asc">升序</option>
						<option value="desc" >降序</option>
						</select></th>
						<th><button type="submit" id="search" >搜索</button></th>
						</tr>
						</table>
						</form>
						<table class="table table-striped table-bordered table-hover" align="center" style="font-size: 18px; font-family: '微软雅黑';">
							<thead style="text-align: center">
								<tr class="tableHead">
									<th style="vertical-align:middle">编号</th>
									<th style="vertical-align:middle">标题</th>
									<th style="vertical-align:middle">发帖人</th>
									<th style="vertical-align:middle">时间</th>
									<th style="vertical-align:middle">头像</th>
									<th style="vertical-align:middle">回帖人</th>
									<th style="vertical-align:middle">回帖</th>
									<th style="vertical-align:middle">回帖时间</th>
									
									
								</tr>
							</thead>
							<tbody>
								<#list Request.list as data>
								<tr>
										<td>${data['id']}</td>
										<td>${data['title']}</td>
										<td><a href="/practice/user/author?author=${data['author']}">${data['author']}</a></td>
										<td>${data['createtime']}</td>
										<td>
											<img src="/practice/static/img/${data['header']}" width="50" height="50"  class="img-circle" />
										</td>
										<td>
										${data['reply_author']}
										</td>
										<td>
										${data['reply_content']}
										</td>
										<td>
										${data['reply_date']}
										</td>
									</tr>
								
								
								</#list>
									
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/practice/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/practice/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/practice/static/js/popover.js"></script>
<script type="text/javascript">

 /* $("#search").click(function(){
	alert("jkdf")
	  var data=$('#searchTopic').serialize(); 
		 var submitData=decodeURIComponent(data,true);
		$.ajax({
		    url:'/practice/user/searchTopic',
		    type:'GET',
		    data:submitData,
		    cache:false,//false是不缓存，true为缓存
		    async:true,//true为异步，false为同步
		    dataType:'json',
		    success:function(result){
		    	}
		    }) 
}) */
</script>
</html>
