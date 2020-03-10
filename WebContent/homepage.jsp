<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎来到花花❀书店！</title>
		<link href="homepagestyle.css" rel="stylesheet" type="text/css" />
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
								<input class="reds" type="text" />
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
						<form name="form1">
							<input type="text" class="bookid" name="bookid" placeholder="请输入书籍id" > 
							<input type="text" class="number" name="number" placeholder="请输入数量" > 
							<input type="button" id="sell" value="销售书籍"/>
						</form>
						<div class="content">
							<table id="book">
								<tr class="tab">
									<td>书号</td>
									<td>类别</td>
									<td>书名</td>
									<td>作者</td>
									<td>出版社</td>
									<td>定价</td>
									<td>库存</td>
								</tr>
								<script>
									/*fso=new ActiveXObject("Scripting.FileSystemObject");
									var f=fso.OpenTextFile("homepage.txt");
									var str=new Array();
									var k=0;	
									var j=0;
									while(!f.AtEndOfStream){
										var temp=f.ReadLine();
										for(var i=0;i<temp.length;i++){
											str[k]=temp[i];
											k++;
											}
										j++;
										}
									*/

									function load(name) {
									    let xhr = new XMLHttpRequest(),
									        okStatus = document.location.protocol === "file:" ? 0 : 200;
									    xhr.open('GET', name, false);
									    xhr.overrideMimeType("text/html;charset=utf-8");//默认为utf-8
									    xhr.send(null);
									    return xhr.status === okStatus ? xhr.responseText : null;
									}
									let f = load("homepage.txt");
									var str=new Array();
									
									str=f.split("\t");
									
								
									/*while(!f.AtEndOfStream){
										var temp=f.ReadLine();
										for(var i=0;i<temp.length;i++){
											str[k]=temp[i];
											k++;
											}
										j++;
										}*/
									
									for(var i=0;i<str.length/7;i++){
										if(i%2!=0)
											document.write("<tr style='background-color:snow'>")
										else
											document.write("<tr>");
										for(var m=0;m<7;m++){
											document.write("<td>")
											document.write(str[(i)*7+m]);
											document.write("</td>")
											}
										document.write("</tr>")
										}
									
									
								</script>
							
								
								
								
							</table>
						</div>
					</div>
					<script type="text/javascript">
				
						
						$("#sell").click(function(){
							var id= $(".bookid").val();
							var number=$(".number").val();
							var flag=confirm("请检查信息是否正确：\n"+"书籍id："+id+"\n数量:"+number);
							var flg1=true;
							var flg2=false
							if(flag){
								var tb=document.getElementById("book");
						//		var str=new Array();
								for(var i=0,rows=tb.rows.length;i<rows;i++){
									for(var j=0,cells=tb.rows[i].cells.length;j<cells;j++){
										
										if(tb.rows[i].cells[j].innerHTML==id){
											flg2=true
											if(tb.rows[i].cells[j+6].innerHTML<number||number<0){
												flg1=false
												break;
												}
											alert("销售成功！");
											tb.rows[i].cells[j+6].innerHTML-=number;
											
									}
									//	str[i*rows+j]=tb.rows[i].cells[j].innerHTML;
									}
								}
								
									
								if(flg2==false)
									alert("未匹配到相应的书籍")
								else if(flg1==false)
									alert("数量输入有误！ ")
								
								
							}
							
						});
						
						
					</script>
					
				</div>
			</div>
			<div class="footing">
				@花花书店管理系统
			</div>
		</div>
	</body>
</html>