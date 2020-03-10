<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<title>欢迎来到花花书店</title>
	<link href="./denglu.css" type="text/css" rel="stylesheet" />
	<script src="jquery-3.4.1.min.js"></script>
</head>
<body>
	<div class="container">
			<div class="wapper">
				<div class="heading">
					<div class="heading_nav">
						<div class="heading_title">
							花花书店管理系统
						</div>
						<div class="heading_img">
							<img src="timg.jfif">
						</div>
						<div class="heading_soptlight">
							<form>
								<input type="text" />
							</form>
						</div>
					</div>
				</div>
				<div class="body">
					<div class="body_title">
						<h3>花花书店管理系统</h3>
						<p>让书店的各项数据变得清晰明朗，让店长不再发愁！</p>
					</div>
					<hr />
					<div class="form_div">
						<form name="name_frm" action="checklogin.jsp" method="get">
							<h2>请先登录</h2>
							<br />
							请选择身份：
							<select id="role" name="role">
								<option value="null">-</option>
								<option value="店员">店员</option>
								<option value="管理员">管理员</option>
							</select>
							<br />
							<input type="text" id="name" name="name" placeholder="请输入用户名" value=""/>
							<br />
							<input type="password" id="paswd" name="paswd" placeholder="请输入密码" value=""/>
							<br />
							<input type="submit" value="确认">
							
							
							
						</form>
						<form>
							<input type="button" id='adduser' value="注册">
						</form>
						<div id="popLayer"></div>
						<div id="userBox">
    					<div class="uclose"></div>
    					<div class="popcontent">
    					
    						<form class="userpopcontent">
    						
    						<p>用户名：</p>
    						 <input type="text" id="username">
    						 <p>密码：</p>
    						 <input type="password" id="userkey">
    						  <p>请再次输入密码：</p>
    						 <input type="password" >
    						 <p>身份：</p>
    						 <select id="useridentify">
    						 	<option value="">-</option>
    						 	<option value="店员">店员</option>
    						 	<option value="管理员">管理员</option>
    						 </select>
    						 <br>
    						 <div style='margin: 10px'>
    						 <input type="button" id='surebtn' value="确定">
    						 <input type="button" id='closebtn' value="取消">
    						 </div>
       						</form>
    					</div>
    					</div>
    					<script>
							$("#adduser").click(function(){
								var popBox = document.getElementById("userBox");
					            var popLayer = document.getElementById("popLayer");
					            popBox.style.display = "block";
					            popLayer.style.display = "block";
								})
							$("#surebtn").click(function(){
								var userdata=new Array();
								userdata[0]=$("#username").val()
								userdata[1]=$("#userkey").val()
								userdata[2]=$("#useridentify").val()

								 var flag=confirm("请确认输入是否无误？")
		            				var idflag=false
		            				var nullflag=false
		            				if(flag){
		        								for(var i=0;i<3;i++){
		        									
		                        					if(userdata[i]=="")
		                            					nullflag=true
		                            					
		                            			
		                        					}
		        									
		                			/*	for(var i=0,rows=booktb.rows.length;i<rows;i+=8){
		                    				for(var j=0;cells)
											if(booktb.rows[i].cells[0].innerHTML==bok[0])
											idflag=true;
		                					}
		                				

		            					*/
		            					if(nullflag==true){
		                					alert("输入数据不能为空哦！")
		                				}
		             					
		             				
		            					if(idflag==false&&nullflag==false){
		            						alert("注册成功！")
		            						
		            						var popBox = document.getElementById("userBox");
           					 				var popLayer = document.getElementById("popLayer");
           					 				popBox.style.display = "none";
           									popLayer.style.display = "none"; 
		                					}
		            				}
		                			
								})
							$("#closebtn").click(function(){
								var popBox = document.getElementById("userBox");
	           					 var popLayer = document.getElementById("popLayer");
	           					 popBox.style.display = "none";
	           					 popLayer.style.display = "none";  
								})
								
								
						</script>
					
						
					</div>
					<hr />
					<div class="ahead_content">
						<div>
							<h4>登录后，你或将实现以下几个功能：</h4>
						</div>
						<div class="ahead_body">
							<div class="ahead_body_content">
								<p>销售书籍</p>
								<small>(店员)</small>
							</div>
							<div class="ahead_body_content">
								<p>书籍管理</p>
								<small>(管理员)</small>
							</div>
							<div class="ahead_body_content">
								<p>用户管理</p>
								<small>(管理员)</small>
							</div>
							<div class="ahead_body_content">
								<p>记录查询</p>
								<small>(管理员)</small>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footing">
				@花花书店管理系统
			</div>
		</div>
	</body>
</body>
</html>