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
						
		<hr />
		<h1 style="position: absolute;margin-top: 0px;margin-left: 20px;" >帖子信息: </h1>
		  
			
			<table style="margin-left: 200px;" >${Session.title} 
			<td>${Session.author}</td>
			<td><img src="/practice/static/img/${Session.header}" width="50" height="50"  class="img-circle" /></td>
			</table><!--传帖子标题-->
			
		
		<h1></h1>
		<hr />
		<div class="container" style="width: 100%;height: 800px;">
		<div></div>
			<div class="row">
				<!--表格-->
				<div class="col-lg-12">
					<div class="text-center">
						
						<table class="table table-striped table-bordered table-hover" align="center" style="font-size: 18px; font-family: '微软雅黑';">
							<thead style="text-align: center">
								<tr class="tableHead">
									
									<th style="vertical-align:middle">回帖编号</th>
									<th style="vertical-align:middle">回复人昵称</th>
									<th style="vertical-align:middle">回复时间</th>
									<th style="vertical-align:middle">回复内容</th>
								</tr>
							</thead>
							<tbody>
							<#list  Request.list as data > 
							<tr>
									
									
									<td>${data['id']}</td>
									<td>${data['reply_author']}</td>
									<td>${data['reply_date']}</td>
									<td>${data['reply_content']}</td>
								</tr>
							
							</#list>
								
								

								

							</tbody>
							
						</table>
						
						<hr />
						<!--<input type="text" style="width: 80%;height: 200px;">-->
						
				
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/practice/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/practice/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/practice/static/js/popover.js"></script>


</html>