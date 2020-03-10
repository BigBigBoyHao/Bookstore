<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎来到花花❀书店！</title>
		<link href="managerhomepage.css" rel="stylesheet" type="text/css" />
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
								<input type="text" class="se" />
							</form>
						</div>
					</div>
				</div>
				<div class="body">
					<div class="body_title">
						<p>---,欢迎登录！</p>
						<p>花花书店管理系统，让书店的各项数据变得清晰明朗，让店长不再发愁！</p>
					</div>
					<hr />
					<div class="body_content">
						<form class="body_choose">
							<input type="button" class="bookc" id="bookc" value="书籍管理"/>
							<input type="button" class="userc" id="userc" value="店员管理"/>
						</form>
						<table id="book" style='display:none'>
								<tr style='background-color:snow'>
									<td>书号</td>
									<td>类别</td>
									<td>书名</td>
									<td>作者</td>
									<td>出版社</td>
									<td>进价</td>
									<td>定价</td>
									<td>库存</td>
								</tr>
								<script>
									function load(name) {
									    let xhr = new XMLHttpRequest(),
									        okStatus = document.location.protocol === "file:" ? 0 : 200;
									    xhr.open('GET', name, false);
									    xhr.overrideMimeType("text/html;charset=utf-8");//默认为utf-8
									    xhr.send(null);
									    return xhr.status === okStatus ? xhr.responseText : null;
									}
									let f = load("manager.txt");
									var str=new Array();
									
									str=f.split("\t");
									console.log(f);
								
									/*while(!f.AtEndOfStream){
										var temp=f.ReadLine();
										for(var i=0;i<temp.length;i++){
											str[k]=temp[i];
											k++;
											}
										j++;
										}*/
									
									for(var i=0;i<str.length/8;i++){
										
										if(i%2!=0)
											document.write("<tr id='"+str[i*8]+"' style='background-color:snow'>")
										else
											document.write("<tr id='"+str[i*8]+"'>");
									
										for(var m=0;m<8;m++){
											document.write("<td>")
											document.write(str[(i)*8+m]);
											document.write("</td>")
											}
										
										}
										document.write("</tr>")
										document.write("<tr id='HHSD-0006' style='display:none'>")
										
										document.write("<td>")
										document.write("HHSD-0006")
										document.write("</td>");
										
										document.write("<td>")
										document.write("漫画")
										document.write("</td>");
										
										document.write("<td>")
										document.write("航海王")
										document.write("</td>");
										
										document.write("<td>")
										document.write("尾田")
										document.write("</td>");
										
										document.write("<td>")
										document.write("日本出版社")
										document.write("</td>");
										
										document.write("<td>")
										document.write("70.00")
										document.write("</td>");
										
										document.write("<td>")
										document.write("90.00")
										document.write("</td>");
										
										document.write("<td>")
										document.write("200")
										document.write("</td>");
										
										document.write("</tr>")	
										
								</script>
									</table>
									
						<table id="user" style='display:none'>
									<tr style='background-color:snow'>
										<td>用户名</td>
										<td>密码</td>
										<td>身份</td>
									</tr>
										
									<script>
									let fu=load("user.txt");
									var st=new Array();
									
									st=fu.split("\t");
									console.log(fu);
									for(var i=0;i<st.length/3;i++){
										if(i%2!=0)
											document.write("<tr id='"+st[i*3]+"' style='background-color:snow'>")
										else
											document.write("<tr id='"+st[i*3]+"'>");
										for(var m=0;m<3;m++){
											document.write("<td>")
											document.write(st[(i)*3+m]);
											document.write("</td>")
											}
										document.write("</tr>")
										}
									document.write("<tr id='小郝'display:none style='display:none;background-color:snow '>")
									document.write("<td>")
									document.write("小郝")
									document.write("</td>")
									
									document.write("<td>")
									document.write("666666")
									document.write("</td>")
									
									document.write("<td>")
									document.write("店员")
									document.write("</td>")
									document.write("</tr>")
									
									document.write("<tr id='老王'display:none style='display:none '>")
									document.write("<td>")
									document.write("老王")
									document.write("</td>")
									
									document.write("<td>")
									document.write("999999")
									document.write("</td>")
									
									document.write("<td>")
									document.write("管理员")
									document.write("</td>")
									document.write("</tr>")
									</script>
						
						</table>
						
					
						
						
					</div>
					<br>
					<hr>
					<div id='bookbutton' style='display: none'>
						<input type="button" value='修改信息' id='changeinfo'/>
						<input type="button" value='书籍入库' id='addbook'/>
						<input type="button" value='删除书籍' id='delbook'/>
					</div>
					<div id='userbutton' style='display: none'>
						<input type="button" value='修改密码' id='changepaswd'/>
						<input type="button" value='添加用户' id='adduser'/>
						<input type="button" value='删除用户' id='deluser'/>
					</div>
					<div id="popLayer"></div>
   						 <div id="popBox">
       					 <div class="close">
           				 <a href="javascript:void(0)" onclick="closeBox()">关闭</a>
       					 </div>
       					 <div class="popcontent">
       					 	<form class="popcontent">
       					 		<p>书号：</p>
       					 		<input type="text" id="bookid" style="width:150px"/>
       					 		<p>类别：</p>
       					 		<select id="bookclass" style="width:150px">
       					 			<option value="">-</option>
       					 			<option value="计算机">计算机</option>
       					 			<option value="经典文学">经典文学</option>
       					 			<option value="医学">医学</option>
       					 			<option value="小说">小说</option>
       					 			<option value="漫画">漫画</option>
       					 		</select>
       					 		<p>书名：</p>
       					 		<input  style="width:150px" type="text" id="bookname"/>
       					 		<p>作者：</p>
       					 		<input type="text" id="author" style="width:150px"/>
       					 		<p>出版社：</p>
       					 		<input type="text" id="bookcbs" style="width:150px"/>
       					 		<p>进价：</p>
       					 		<input type="text" id="jfew" style="width:150px"/>
       					 		<p>定价：</p>
       					 		<input type="text" id="dfew" style="width:150px"/>
       					 		<p>入库数量：</p>
       					 		<input type="text" id="booknum" style="width:150px"/>
       					 		<br>
       					 		<input type="button" id="sure" style="height:45px; width:50px; font-size:20px; margin-left:100px;margin-top:10px" value="确定"/>
       					 	</form>
       					 </div>
    					</div>
    					<div id="userBox">
    					<div class="uclose"></div>
    					<div class="popcontent">
    					
    						<form class="userpopcontent">
    						
    						<p>用户名：</p>
    						 <input type="text" id="username">
    						 <p>密码：</p>
    						 <input type="password" id="userkey">
    						 <p>再次确认密码：</p>
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
						$("#bookc").click(function(){
							$("#user").hide();
							$("#book").show();
							$("#bookbutton").show();
							$("#userbutton").hide();
							})
						$("#userc").click(function(){
							$("#user").show();
							$("#book").hide();
							$("#bookbutton").hide();
							$("#userbutton").show();
							})
						$("#book").dblclick(function(){
							var td=event.srcElement;
							var tab = document.getElementById("book");
							var flag= confirm("是否修改第"+(td.parentElement.rowIndex + 1)+"行的信息？")
					        if(flag){
					        	var newdata=prompt("请修改（原值为："+td.innerText+"）：",td.innerText);
									td.innerText=newdata;
									alert("修改成功！");	
						        }
							})
							
						$("#addbook").click(function(){
							//var id=prompt(")
							var popBox = document.getElementById("popBox");
				            var popLayer = document.getElementById("popLayer");
				            popBox.style.display = "block";
				            popLayer.style.display = "block";
							})
							
							 function closeBox() {
           					 var popBox = document.getElementById("popBox");
           					 var popLayer = document.getElementById("popLayer");
           					 popBox.style.display = "none";
           					 popLayer.style.display = "none";           					 
        				}
        				$("#sure").click(function(){
            				var bok=new Array();
            				 bok[0]=$("#bookid").val();
            				 bok[1]=$("#bookclass").val();
            				 bok[2]=$("#bookname").val();
            				 bok[3]=$("#author").val();
            				 bok[4]=$("#bookcbs").val();
            				 bok[5]=$("#jfew").val()
            				 bok[6]=$("#dfew").val()
            				 bok[7]=$("#booknum").val()
            			     var flag=confirm("请确认输入是否无误？")
            				var idflag=false
            				var nullflag=false
            				var numflag=false
            				if(flag){
            					
            					
            					var tb=document.getElementById("book");
        						//		var str=new Array();
        								for(var i=0,rows=tb.rows.length;i<rows-1;i++){
        									for(var j=0,cells=tb.rows[i].cells.length;j<cells;j++){
        										
        										if(tb.rows[i].cells[j].innerHTML==bok[0]){
        											idflag=true;
        											
        									}
        									//	str[i*rows+j]=tb.rows[i].cells[j].innerHTML;
        									}
        								}
        								for(var i=0;i<8;i++){
                        					if(bok[i]=="")
                            					nullflag=true
                            				if(i>4){
                                				if(bok[i]<=0)
                                    			numflag=true
        		
                                				}
                        					}
        									
                			/*	for(var i=0,rows=booktb.rows.length;i<rows;i+=8){
                    				for(var j=0;cells)
									if(booktb.rows[i].cells[0].innerHTML==bok[0])
									idflag=true;
                					}
                				

            					*/
            					if(nullflag==true)
                					alert("输入数据不能为空哦！")
                				}
             					if(numflag==true){
									alert("请输入正整数嗷！")
                 					}
             					if(idflag==true){
                 					alert("这本书已经存在了！请检查书号是否填写正确。")
                 					}
            					if(idflag==false&&numflag==false&&nullflag==false){
            						alert("填写数据成功！")
            						closeBox()
            						$("#HHSD-0006").show();
                					}
                			
                				
            				})
            			$("#delbook").click(function(){
                			//var a="HHSD-0002";
                			//$("#"+a).hide();
                			var content = true;
                			var contentflag = false;
                			var delid = prompt("请输入你要删除的书籍id：");
                			if(delid=="")
                    			content=false
                    		
							if(content==true){
								var tb=document.getElementById("book");
        						//		var str=new Array();
        								for(var i=0,rows=tb.rows.length;i<rows;i++){
        									for(var j=0,cells=tb.rows[i].cells.length;j<cells;j++){
        										
        										if(tb.rows[i].cells[j].innerHTML==delid){
        											contentflag=true;
        											
        									}
        									//	str[i*rows+j]=tb.rows[i].cells[j].innerHTML;
        									}
        								}
								}
								if(contentflag==false&&content==true){
									alert("找不到这本书呢！")
									}
								else if(content==false)
									alert("输入不能为空！");
								else{
									alert("删除书籍成功！")
									$("#"+delid).hide();
									}	
            			})
            			
						</script>
						<script>
							$("#changepaswd").click(function(){
								var name = prompt("请输入要修改的用户名：","")
								
								if(name=="")
									alert("输入不能为空嗷！");
								else{
									var flag = false
									var tb=document.getElementById("user");
	        						//		var str=new Array();
	        								for(var i=0,rows=tb.rows.length;i<rows;i++){
	        									for(var j=0,cells=tb.rows[i].cells.length;j<cells;j++){
	        										
	        										if(tb.rows[i].cells[j].innerHTML==name){
	        											flag=true;
	        											
	        									}
	        									//	str[i*rows+j]=tb.rows[i].cells[j].innerHTML;
	        									}
	        								}
	        								if(flag==false)
		        								alert("不存在该用户！");
	        								else{
												var really = confirm("确认是否修改用户："+name+"?")
												if(really)
													{
													var newpassword=prompt("请输入新密码")
													var surepassword=prompt("请再次确认密码")
													if(newpassword==surepassword){
														alert("修改成功！")
														for(var i=0,rows=tb.rows.length;i<rows;i++){
				        									for(var j=0,cells=tb.rows[i].cells.length;j<cells;j++){
				        										
				        										if(tb.rows[i].cells[j].innerHTML==name){
				        											tb.rows[i].cells[j+1].innerHTML=newpassword;
				        									}
				        									//	str[i*rows+j]=tb.rows[i].cells[j].innerHTML;
				        									}
				        								}

														}else{
															alert("两次密码输入不一致！修改失败。")

															}

													}
		        								}

									}

								})
						</script>
						
						
						
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
		            					
		            					
		            					var tb=document.getElementById("user");
		        						//		var str=new Array();
		        								for(var i=0,rows=tb.rows.length;i<rows-2;i++){
		        									for(var j=0,cells=tb.rows[i].cells.length;j<cells;j++){
		        										
		        										if(tb.rows[i].cells[j].innerHTML==userdata[0]){
		        											idflag=true;
		        											
		        									}
		        									//	str[i*rows+j]=tb.rows[i].cells[j].innerHTML;
		        									}
		        								}
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
		             					
		             					if(idflag==true){
		                 					alert("这个人已经存在了！")
		                 					}
		            					if(idflag==false&&nullflag==false){
		            						alert("填写数据成功！")
		            						var popBox = document.getElementById("userBox");
           					 				var popLayer = document.getElementById("popLayer");
           					 				popBox.style.display = "none";
           									popLayer.style.display = "none";   
		            						$("#"+userdata[0]).show();
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
						
						<script>
							$("#deluser").click(function(){
								var content = true;
	                			var contentflag = false;
	                			var delid = prompt("请输入你要删除的用户姓名：");
	                			if(delid=="")
	                    			content=false
	                    		
								if(content==true){
									var tb=document.getElementById("user");
	        						//		var str=new Array();
	        								for(var i=0,rows=tb.rows.length;i<rows;i++){
	        									for(var j=0,cells=tb.rows[i].cells.length;j<cells;j++){
	        										
	        										if(tb.rows[i].cells[j].innerHTML==delid){
	        											contentflag=true;
	        											
	        									}
	        									//	str[i*rows+j]=tb.rows[i].cells[j].innerHTML;
	        									}
	        								}
									}
									if(contentflag==false&&content==true){
										alert("找不到这个人呢！")
										}
									else if(content==false)
										alert("输入不能为空！");
									else{
										alert("删除用户成功！")
										var popBox = document.getElementById("userBox");
           					 				var popLayer = document.getElementById("popLayer");
           					 				popBox.style.display = "none";
           									popLayer.style.display = "none"; 
										$("#"+delid).hide();
									}	
	            			})
								
						</script>
				</div>
			</div>
			<div class="footing">
				@花花书店管理系统
			</div>
		</div>
	</body>
</html>