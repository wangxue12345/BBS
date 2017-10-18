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
						<h1>用户信息</h1>
						
						<table  class="table table-striped table-bordered table-hover" align="center" style="font-size: 18px; font-family: '微软雅黑';">
							<thead style="text-align: center">
								<tr class="tableHead">
								</tr>
							</thead>
							<tbody>
								<tr>
									<th style="vertical-align:middle">用户姓名</th>
									<td>${message.name }</td>
								</tr>

								<tr>
									<th style="vertical-align:middle">昵称</th>
									<td>${message.nickname }</td>
								</tr>

								
								<tr>
								<th style="vertical-align:middle">身份证号</th>
								<td>${message.idcard }</td>
								</tr>
								<tr>
									<th style="vertical-align:middle">性别</th>
									<td><#if message.sex lt 1 >女
									<#else >男
									</#if>
									</td>
								</tr>
								<tr>
									<th style="vertical-align:middle">电话</th>
									<td>${message.telphone }</td>
								</tr>
								<tr>
									<th  style="vertical-align:middle">头像</th>
									<td><img src="/practice/static/img/${message.img }" id="headerimg" width="50" height="50" class="img-circle" /></td>
								</tr>
								
							</tbody>
						</table>
					<button type="button"  id="updateAuthor" onclick="testDisplay()">修改信息</button>
					
						<form action="/practice/user/updateAuthor"  id="uploadForm"  style="display:none"  enctype="multipart/form-data"  method="get" >
						<table   id="update" class="table table-striped table-bordered table-hover" align="center" style="font-size: 18px; font-family: '微软雅黑';">
							<thead style="text-align: center">
								<tr class="tableHead">
								</tr>
							</thead>
							<tbody>
								<tr>
									<th style="vertical-align:middle">用户姓名</th>
									<td><input type="text" name="name"></td>
								</tr>

								<tr>
									<th style="vertical-align:middle">昵称</th>
									<td><input type="text"  name="nickname"></td>
								</tr>

								
								<tr>
								<th style="vertical-align:middle">身份证号</th>
								<td><input type="text"  name="idcard"></td>
								</tr>
								<tr>
									<th style="vertical-align:middle">性别</th>
								<td><input type="text"  name="sex"></td>
								</tr>
								<tr>
									<th style="vertical-align:middle">电话</th>
									<td><input type="text"  name="telphone"></td>
								</tr>
								<tr>
									<th style="vertical-align:middle"><button type="submit">确认</button></th>
									
								</tr>
							
							</tbody>
							</table>
						</form>
						<form  action="/practice/user/uploadHeader?name=${message.name }" method="post" enctype="multipart/form-data">
						
								<th style="vertical-align:middle">修改头像</th>
								
									<td><input type="file"  name="file"  id="uploadFile" style="margin-left: 100px" />
									<input  type="submit"   style="margin-left: 100px" value="点击上传"/></td>
							
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/practice/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/practice/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/practice/static/js/popover.js"></script>
	<script type="text/javascript">
	function testDisplay()
	{
	    var divD = document.getElementById("uploadForm");
	    if(divD.style.display=="none")
	    {
	        divD.style.display = "block";
	    }
	    else
	    {
	        divD.style.display = "none";
	    }
	}
	</script>

</html>