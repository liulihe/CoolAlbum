<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的个人中心</title>
<%@include file="/WEB-INF/common/js-css-file.jsp"%>
<style type="text/css">
body {background-color: #C7EDCC;}
</style>
</head>
<body>
	<div class="container">
		<!-- 栅格开始  -->
		<div class="row">
			<!--栅格占用2 偏移10 -->
			<div class="col-md-2">
				<!-- 下拉菜单 -->
				<div class="dropdown">
					
					<button style="background-color:#C7EDCC; border: 0" class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${curMember.mNickname } 
						<span class="caret"></span>
					</button>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="background-color:#C7EDCC;">
						<br>
						<li><a id="myInfo" href="#"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 我的资料</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="updatePassword" href="#"> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 修改密码</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="logout" href="#"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> 注销</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 顶部栅格结束 -->

		<!-- 栅格开始 -->
		<div class="row">
			<!-- 菜单 -->
			<%@include file="/WEB-INF/common/menu.jsp"%>
			
			<!-- 内容 -->
			<div class="col-md-10">
				
				<div id="contentDiv">
					新的一天 新的sang
					<!-- 调用天气插件 -->
					<%@include file="/WEB-INF/common/weather.jsp"%>
				</div>

				<div id="uploadDiv"class="col-md-5" >
					<!-- 表单 -->
					<form id="submitPhotoForm" action="${appPath }/photo/upload" method="post" enctype="multipart/form-data">
						<c:if test="${not empty uploadErrorMsg }">
							<span id="upload_error_msg" style="color: red;">${uploadErrorMsg.msg }</span>
						</c:if>
						<div class="form-group">
							<label>添加相片</label> 
							<input type="file" name="upFile" class="form-control" multiple="multiple">
						</div>
						<div class="form-group desc">
							<label>相片名称</label> 
							<input type="text" name="pName" class="form-control" placeholder="相册名称">
						</div>
						<div class="form-group desc">
							<label>相片分类</label> 
							<select id="phototype" name="pTypeId" class="form-control"></select>
						</div>
						<div class="form-group desc">
							<label>相片描述</label> 
							<textarea rows="5" cols="50" name="pDescription" class="form-control desc" placeholder="相册描述"></textarea>
						</div>
						<a id="submitPhoto" class="btn btn-success">提交</a>
					</form>
				</div>
				
				<div id="scanDiv"></div>
				
				<div id="friendPhotoDiv">
					
					<!-- 图片筛选 -->
					<div id="fpSelect">
						<div class="row">
							<div class="col-md-3">
								<input id="photosize" type="text" class="form-control" placeholder="显示多少张图片">
							</div>
							
							<div class="col-md-3">
								<select id="phototypeid" name="phototypeid" class="form-control">
									<option value="0">所有图片</option>
								</select>
							</div> 
							<a id="photoselect" class="btn btn-default" href="#" role="button">筛选</a>
						</div>
					</div>
					<hr>
					
					<!-- 图片展示 -->
					<div id="fpDiv"></div>
					
					<hr>
					<!-- 分页 -->
					<div id="fpnavnum">
						<div>
							<nav aria-label="Page navigation">
							<ul class="pagination">
							</ul>
							</nav>
						</div>
					</div>
					
					<hr>
					<!-- 留言 -->
					<div id="fpmessageDiv">
						<div id="messageDiv" style="display: none;">
							<div id="multitext">
							</div><br>
							<button id="messageSubmit" type="button" class="btn btn-primary">提交留言</button>
						</div>
						<button id="leaveMessage" type="button" class="btn btn-primary">给ta留言</button>
						<hr>
					</div>
				</div>
				
				<div id="typeDiv">
					
					<!-- 按钮 -->
					<div class="row">
						<div class="col-md-3 col-md-offset-9">
							<button id="addPhototype" type="button" class="btn btn-info">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加类型
							</button>
							<button id="partDeletetype" type="button" class="btn btn-warning">
								<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> 批量删除
							</button>
						</div>
					</div>
					
					<br>
					
					<!-- 警告框 -->
					<div class="row">
						<div class="col-md-10">
							<div class="alert alert-success" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>警告!</strong>删除类型会删除类型下的所有图片
							</div>
						</div>
					</div>
					
					<table id="typeTable" class="table">
						<thead>
							<tr>
								<td><input type="checkbox" class="checkAll"></td>
								<td>名称</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody id="typdBody">
						</tbody>
					</table>	
				</div>
				
				<div id="friendDiv">
					<div class="input-group col-md-4 col-md-offset-8">
						<input type="text" class="form-control" id="searchText" placeholder="输入账号直接添加"/> 
						<span class="input-group-addon" id="searchButton"> 
							<a href="#">搜索</a>
						</span>
					</div>
					<div id="searchResult" class="col-md-4 col-md-offset-8" style="display: none;">
						<span id="resultSpan"></span>
					</div>
					<div id="friendList">
						<table id="friendTable" class="table table-hover table-striped">
							<thead>
								<tr>
									<td>好友</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody id="friendBody">
							</tbody>
						</table>	
					</div>
				</div>
				
				<div id="mymessageDiv">
					
				</div>
				
			</div>
		</div>
		<!-- 栅格结束 -->
		
	</div>

	<!-- 添加图片类型模态框 -->
	<div id="addPhotoTypeModal" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加图片类型</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>图片类型名称</label> 
						<input type="text" class="form-control" forUpdate="" id="phototype_input" placeholder="请输入图片类型名称">
						<span id="phototype_span" style="color: red;"></span>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="confirmAddType" type="button" class="btn btn-primary">确认添加</button>
					<span id="confirmSpan" select=""></span>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	<!-- 图片详情modal -->
	<div id="photo_detail_modal"  class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">详情</h4>
				</div>
				<div class="modal-body">
					<img id="pd_img" src="" class="img-responsive" alt="Responsive image">
					<hr>
					<div class="form-group">
						<label>图片名称</label> 
						<p id="pd_name"></p>
					</div>
					<div class="form-group">
						<label>所属分类</label> 
						<p id="pd_type"></p>
					</div>
					<div class="form-group">
						<label>创建时间</label> 
						<p id="pd_createtime"></p>
					</div>
					<div class="form-group">
						<label>描述</label><br>
						<textarea  id="pd_detail" class="form-group" rows="3" cols="50" style="border: 0">
						</textarea>						
					</div>	
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	
	<!-- 我的资料modal -->
	<div id="myInfoModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">我的资料</h4>
				</div>
				<div class="modal-body">
					<form action="#" method="post" id="myInfoForm">
						<div class="form-group">
							<label class="control-label">账号</label>
							<p class="form-control-static">${curMember.mAccountname }</p>
						</div>
						<div class="form-group">
							<label class="control-label">昵称</label>
							<input type="text" id="myNickName" name="mNickname" class="form-control" placeholder="输入昵称">
						</div>
						<div class="form-group">
							<label class="control-label">邮箱</label>
							<input type="email" id="myEmail" name="mEmail" class="form-control" placeholder="输入邮箱">
						</div>
						<div class="form-group">
							<label class="control-label">手机号</label>
							<p class="form-control-static">${curMember.mPhone }</p>
						</div>
						<div class="form-group">
							<label class="control-label">账号创建时间</label>
							<p class="form-control-static">${curMember.mCreatetime }</p>
						</div>
						<div class="form-group">
							<label class="control-label">个性签名</label>
							<textarea id="mySignature" name="mSignature" class="form-control" rows="3"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="submitMyInfo" type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- 修改密码模态框 -->
	<div id="update_password_modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body">
					<!-- 修改密码表单 -->
					<form id="update_password_form" action="${appPath}/member/comfirmUpdatePassword" method="post">
					
						<span id="update_password_span" style="color: red;"></span>
					
						<div class="form-group">
							<label>旧密码</label> 
							<input id="old_password" name="oldPassword" type="password" class="form-control" placeholder="旧密码">
							<span class="errorInfo" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label>新密码</label> 
							<input id="new_password" name="newPassword" type="password" class="form-control" placeholder="新密码">
							<span class="errorInfo" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label>确认密码</label>
							<input id="confirm_password"  name="comfirmPassword" type="password" class="form-control" placeholder="确认密码">
							<span class="errorInfo" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label>输入验证码</label> 
							<input id="validate_code"  name="validateCode" type="text" class="form-control" placeholder="请输入手机验证码">
							<span class="errorInfo" style="color: red;"></span>
							<a id="get_validate_code" class="btn btn-default" href="#">获取验证码</a>
							<span id="time_show" style="display: none;">请在<strong id="left_time"></strong>秒内输入验证码</span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="comfirm_update_password" type="button" class="btn btn-primary">修改</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 设置别备注 -->
	<div id="namedFriendModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">备注</h4>
				</div>
				<div class="modal-body">
					<input id="namedFriendInput" type="text" class="form-control" placeholder="最多十字中文字符">
					<span style="color: red;"></span>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="confirm_named_friend" type="button" class="btn btn-primary">修改</button>
				</div>
			</div>
		</div>
	</div>

</body>

<script>
	
	/* 页面加载完成 */
	$(function(){
		/* 获取上传图片表单错误信息 */
		var upload_error_msg=$("#upload_error_msg").text();
		/* 如果错误错误信息不为空，来到上传tab页 */
		if(upload_error_msg.length>=1){
			/* 填充图片类型 */
			getPhotoType("fill");
			$("#uploadDiv").show().siblings().hide();
			/* 清空错误信息 */
			$("#upload_error_msg").text();
		}else{
			/* 来到首页 */
			$("#contentDiv").show().siblings().hide();
		}
	});
	
	/* 页面加载完成 */
	$.ajax({
		url:"${appPath}/historytoday",
		type:"GET",
		success:function(result){
			console.log(result);
		}
	});
	
	/* 填充到上传图片表单 */
	function fillToUploadForm(result){
		/* 每次填充前先清空 */
		$("#phototype").empty();
		/* 遍历填充 */
		$.each(result.content,function(){
			$("#phototype").append($("<option value='"+this.pId+"'></option>").append(this.pTypename));
		});
	}
	
	/* 填充到图片类型操作表格 */
	function fillToPhototypeOpe(result){
		/* 清空 */
		$("#typdBody").empty();
		
		/* 遍历  */
		$.each(result.content,function(){
			var tr=$("<tr></tr>");
			var tdCheck=$("<td></td>").append($("<input type='checkbox' class='singleCheck'>"));
			var tdPTypename=$("<td></td>").append(this.pTypename);
			
			/* 操作 按钮 */
			var editBtnSpan=$("<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>");
			var editBtn=$("<button type='button' pId='"+this.pId+"' class='btn btn-primary btn-sm edittype'></button>");
			var delBtnSpan=$("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");
			var delBtn=$("<button type='button' pId='"+this.pId+"' class='btn btn-danger btn-sm deletetype'></button>");
			var tdOpeBtn=$("<td></td>").append(editBtn.append(editBtnSpan)).append(" ").append(delBtn.append(delBtnSpan));
			
			/* 填充  */
			tr.append(tdCheck).append(tdPTypename).append(tdOpeBtn);
			$("#typdBody").append(tr);
		});
	}
	
	var photo_type;
	/* 查询出所有图片类型 */
	function getPhotoType(selection){
		/* 从数据库中查询出所有图片类型，填充到图片分类option */
		$.ajax({
			url:"${appPath}/phototype/gettype",
			type:"POST",
			/* 必须为同步，否则在图片详情页获取图片类型时获取不到 */
			async:false,
			success:function(result){
				/* 如果查询有结果 */
				if(result.content.length>=1){
					/* 作为一个公共的 */
					photo_type=result.content;
					
					if(selection=="fill"){
						/* 如果是上传 */
						fillToUploadForm(result);
					}else if(selection=="typeOpe"){
						/* 如果是编辑 */
						fillToPhototypeOpe(result);
					}else{
					}
				}else{
					/* 查询无结果 */
					var tipMessage=$("<h2></h2>").text("一个分类也没有......");
					$("#typdBody").empty().append(tipMessage);
				}
			},
			error:function(XMLHttpRequest, textStatus){
				alert('获取图片类型失败，请重试');
			}
		});
	}

	/* 点击上传按钮 */
	$("#uploadFile").click(function(){
		getPhotoType("fill");
		$("#uploadDiv").show().siblings().hide();
	});
	
	/* 填充图片 */
	function fill_photo(result){
		/* 清空 */
		$("#scanDiv").empty();
		/* 获取图片类型 */
		getPhotoType("other");
		/* 追加填充 */
		var rowDiv=$("<div class='row'></div>");
		$.each(result.content,function(index){
			
			var imgUrl="${appPath}/"+this.pUrl;
			var img=$("<img src='"+imgUrl+"' style='height: 200px;width: 200px;'></img>");
			var a=$("<a href='#' class='thumbnail'></a>").append(img);
			/* 图片操作按钮 */
			
			var likespan=$("<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'></span>");
			var like=$("<button type='button' pId='"+this.pId+"' class='iflike btn btn-default' aria-label='Left Align'></button>");
			
			/* 要注意pClicklikeMemberid为null的情况，以及判断为null时，null不要加双引号 */
			if(this.pClicklikeMemberid!=null&&this.pClicklikeMemberid.includes("${curMember.mId}")){
				like.removeClass("btn-default").addClass("btn-success");
			}
			
			var detailSpan=$("<span class='glyphicon glyphicon-picture' aria-hidden='true'></span>");
			var detail=$("<button type='button' pId='"+this.pId+"' class='photoDetail btn btn-default' aria-label='Left Align'></button>");
			
			var singleDeleteSpan=$("<span class='glyphicon glyphicon-trash' aria-hidden='true'></span>");
			var singleDelete=$("<button type='button' pId='"+this.pId+"' class='singleDelete btn btn-default' aria-label='Left Align'></button>");
			
			var opeBtn=$("<p></p>").append(like.append(likespan)).append(" ").append(detail.append(detailSpan)).append(" ").append(singleDelete.append(singleDeleteSpan));
			var div=$("<div class='col-md-3'></div>").append(a).append(opeBtn);
			rowDiv.append(div);
		});
		$("#scanDiv").append(rowDiv);
	}
	
	/* 点击浏览按钮 */
	$("#scanFile").click(function(){
		$("#scanDiv").show().siblings().hide();
		$.ajax({
			url:"${appPath}/photo/getAllPhoto",
			type:"GET",
			success:function(result){
				/* 成功 */
				if(result.code==1){
					/* 填充图片信息 */
					fill_photo(result);
				}else{
					jqueryAlert({'content' : '一个图片也没有','closeTime' : 2000});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert(textStatus);
			}
		});
	});
	
	/* 图片点赞点击 */
	$("body").on("click",".iflike",function(){
		var likeButton=$(this);
		$.ajax({
			url:"${appPath}/photo/clicklike",
			type:"GET",
			data:"pId="+$(this).attr("pId"),
			success:function(result){
				if(result.code==1){
					likeButton.removeClass("btn-default").addClass("btn-success");;
				}
				jqueryAlert({'content' : result.msg,'closeTime' : 1000});
			},
			error:function(XMLHttpRequest,textStatus){
				alert('发生未知错误！');
			}
		});
	});
	
	/* 时间转换 */
	function getdate(date) {
        var now = new Date(date),
            y = now.getFullYear(),
            m = now.getMonth() + 1,
            d = now.getDate();
        return y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d) + " " + now.toTimeString().substr(0, 8);
    }
	
	/* 图片详情点击 */
	$("body").on("click",".photoDetail",function(){
		$("#photo_detail_modal").modal("show");
		$.ajax({
			url:"${appPath}/photo/getDelicatedPhoto",
			data:{"pId":$(this).attr("pId")},
			success:function(result){
				if(result.code==1){
					/* 清空填充 */
					$("#pd_img").prop("src","").prop("src","${appPath}/"+result.content.pUrl);
					$("#pd_name").text("").text(result.content.pName);
					$("#pd_createtime").text("").text(getdate(result.content.pCreatetime));
					$("#pd_detail").text("").text(result.content.pDescription);
					
					/* 如果不为空，遍历所有类型 */
					if(photo_type!=undefined){
						$.each(photo_type,function(index,element_photo_type){
							/* 如果某一个类型和当前图片的类型一致 */
							if(element_photo_type.pId==result.content.pTypeId){
								/* 填充此类型到当前图片的详情信息 */
								$("#pd_type").text("").text(element_photo_type.pTypename);
							}
						});
					}
				}
			}
		});
	});
	
	/* 图片单个删除点击 */
	$("body").on("click",".singleDelete",function(){
		var curObj=$(this);
		var pId=curObj.attr("pId");
		$.ajax({
			url:"${appPath}/photo/singledelete",
			type:"GET",
			data:"pId="+pId,
			success:function(result){
				if(result.code==1){
					/* 移除图片 */
					curObj.parents(".col-md-3").remove()
					jqueryAlert({'content' : '删除成功！','closeTime' : 1000});
				}else{
					jqueryAlert({'content' : '删除失败！','closeTime' : 1000});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert("error");
			}
		});
	});
	
	/* 查找所有好友 */
	function getFriend(){
		$.ajax({
			url:"${appPath}/friend/getfriend",
			success:function(result){
				if(result.code==1){
					$("#friendBody").empty();
					$.each(result.content,function(index,element){
						if(this.fNamedfriend.length==0){
							var acctTd=$("<td></td>").append(this.fFriendacct);
						}else{
							var acctTd=$("<td></td>").append(this.fNamedfriend);
						}
						var accessBtnSpan=$("<span class='glyphicon glyphicon-menu-right' aria-hidden='true'></span>");
						var accessBtn=$("<a data='"+this.fFriendid+"' class='btn btn-primary btn-xs accessBtn' href='#' role='button'></a>");
						 
						var namedBtnSpan=$("<span class='glyphicon glyphicon-saved' aria-hidden='true'></span>");
						var namedBtn=$("<a data='"+this.fFriendid+"' class='btn btn-success btn-xs namedBtn' href='#' role='button'></a>");
						
						var deleteBtnSpan=$("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");
						var deleteBtn=$("<a data='"+this.fFriendid+"' class='btn btn-danger btn-xs deleteBtn' href='#' role='button'></a>");
						if(this.fIsblack==0){
							
							var blackBtnSpan=$("<span class='glyphicon glyphicon-plus-sign' aria-hidden='true'></span>");
							var blackBtn=$("<a data='"+this.fFriendid+"' class='btn btn-warning btn-xs blackBtn' href='#' role='button'></a>");
						}else{
							var blackBtnSpan=$("<span class='glyphicon glyphicon-minus-sign' aria-hidden='true'></span>");
							var blackBtn=$("<a data='"+this.fFriendid+"' class='btn btn-warning btn-xs blackBtn' href='#' role='button'></a>");
						}
						var opeTd=$("<td></td>").append(accessBtn.append(accessBtnSpan)).append(" ").append(namedBtn.append(namedBtnSpan)).append(" ").append(deleteBtn.append(deleteBtnSpan)).append(" ").append(blackBtn.append(blackBtnSpan));
						var tr=$("<tr style='background-color: #C7EDCC;'></tr>").append(acctTd).append(opeTd);
						$("#friendBody").append(tr);
					});
				}else{
					jqueryAlert({'content' : result.msg,'closeTime' : 1000});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert(textStatus);
			}
		});
	}
	
	
	/* 填充好友的图片 */
	function fill_friendphoto(result){
		/* 清空 */
		$("#fpDiv").empty();
		/* 追加填充 */
		var rowDiv=$("<div class='row'></div>");
		$.each(result,function(index){
			var imgUrl="${appPath}/"+this.pUrl;
			var img=$("<img src='"+imgUrl+"' style='height: 200px;width: 200px;'></img>");
			var a=$("<a href='#' class='thumbnail'></a>").append(img);
			
			/* 图片操作按钮 */
			var likespan=$("<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'></span>");
			var like=$("<button type='button' pId='"+this.pId+"' class='iflike btn btn-default' aria-label='Left Align'></button>");
			
			/* 要注意pClicklikeMemberid为null的情况，以及判断为null时，null不要加双引号 */
			if(this.pClicklikeMemberid!=null&&this.pClicklikeMemberid.includes("${curMember.mId}")){
				like.removeClass("btn-default").addClass("btn-success");
			}
			
			var detailspan=$("<span class='glyphicon glyphicon-picture' aria-hidden='true'></span>");
			var detail=$("<a href='#' pId='"+this.pId+"' class='btn btn-default photoDetail' role='button'></a>");
			var opeBtn=$("<p></p>").append(like.append(likespan)).append(" ").append(detail.append(detailspan));
			var div=$("<div class='col-md-3'></div>").append(a).append(opeBtn);
			rowDiv.append(div);
		});
		$("#fpDiv").append(rowDiv);
		
		/*  */
		
	}
	
	/* 填充好友的图片类型 */
	function fill_friendphototype(result){
		photo_type=result;
		$("#phototypeid").children("option:gt(0)").empty();
		$.each(result,function(index){
			$("#phototypeid").append("<option value='"+this.pId+"'>"+this.pTypename+"</option>");
		});
	}

	/* 填充分页 */
	function fill_pagenum(result){
		/* 清空 */
		$(".pagination").empty();
		
		/* 首页 */
		var homepage=$("<li class='navnum'><a href='${appPath}/friend/access?pn=1' aria-label='Previous'>首页</a></li>");
		$(".pagination").append(homepage);
		
		/* 如果有上一页 */
		if(result.hasPreviousPage){
			var previouspagenum=result.pageNum-1;
			var previouspage=$("<li class='navnum'><a href='${appPath}/friend/access?pn="+previouspagenum+"' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
			$(".pagination").append(previouspage);
		}

		
		/* 遍历导航 */
		$.each(result.navigatepageNums,function(){
			/* 判断是否为当前页，如果是，按钮就高亮显示 */
			if(this==result.pageNum){
				var curpage=$("<li class='active navnum'><a href='${appPath}/friend/access?pn="+this+"'>"+this+"</a></li>");
			}else{
				var curpage=$("<li class='navnum'><a href='${appPath}/friend/access?pn="+this+"'>"+this+"</a></li>");
			}
			$(".pagination").append(curpage);
		});
		
		/* 如果有下一页 */
		if(result.hasNextPage){
			var nextpagenum=result.pageNum+1;
			var nextpage=$("<li class='navnum'><a href='${appPath}/friend/access?pn="+nextpagenum+"' aria-label='Previous'><span aria-hidden='true'>&raquo;</span></a></li>");
			$(".pagination").append(nextpage);
		}
		
		/* 末页 */
		var endpage=$("<li class='navnum'><a href='${appPath}/friend/access?pn="+result.pages+"' aria-label='Previous'>末页 </a></li>");
		$(".pagination").append(endpage);
	}
	
	function accessFriendPhoto(friendId){
		$("#friendPhotoDiv").show().siblings().hide();
		$.ajax({
			url:"${appPath}/friend/access",
			type:"GET",
			data:{"friendId":friendId},
			success:function(result){
				/* 填充图片类型 */
				if(result.ext.phototype=="nothing"){
				}else{
					fill_friendphototype(result.ext.phototype);
				}
				
				/* 填充图片 */
				if (result.ext.pageInfoMsg == "nothing") {
					$("#fpDiv").text("没有照片");
				} else {
					fill_friendphoto(result.ext.pageInfoMsg.list);
				}
				
				/* 填充分页 */
				fill_pagenum(result.ext.pageInfoMsg);
			}
		});
	}
	
	/* 点击访问 */
	var friendId="";
	$("body").on("click",".accessBtn",function(){
		friendId=$(this).attr("data");
		$.ajax({
			url:"${appPath}/friend/trytoaccess",
			type:"GET",
			data:{"friendId":friendId},
			success:function(result){
				if(result.code!=1){
					alert(result.msg);
				}else{
					accessFriendPhoto(friendId);
				}
			}
		});
	});
	
	
	/* 点击图片筛选 */
	$("#photoselect").click(function() {
		$.ajax({
			url:"${appPath}/friend/access",
			type:"GET",
			data:{
				"friendId":friendId,
				"ps":$("#photosize").val(),
				"phototypeid":$("#phototypeid").val(),
				"friendId":friendId
			},
			success:function(result){
				/* 填充图片 */
				fill_friendphoto(result.ext.pageInfoMsg.list);
				/* 填充分页 */
				fill_pagenum(result.ext.pageInfoMsg);
			}
		});
	});
	
	/* 点击导航页 */
	$("body").on("click",".navnum",function(){
		$.ajax({
			url:$(this).children("a").attr("href"),
			type:"GET",
			data:{
				"friendId":friendId,
				"ps":$("#photosize").val(),
				"phototypeid":$("#phototypeid").val(),
				"friendId":friendId
			},
			success:function(result){
				/* 填充图片 */
				fill_friendphoto(result.ext.pageInfoMsg.list);
				/* 填充分页 */
				fill_pagenum(result.ext.pageInfoMsg);
			}
		});
		return false;
	});
	
	/* 点击设置备注 */
	var curNameOpeBtn;
	$("body").on("click",".namedBtn",function(){
		curNameOpeBtn=$(this);
		$("#namedFriendModal").modal("show");
	});
	
	/* 备注输入框事件 */
	$("#namedFriendInput").focus(function(){
		/* 清空错误消息 */
		$(this).text("").next().text("");
	});
	
	/* 备注确认 */
	$("#confirm_named_friend").click(function(){
		var friendId=curNameOpeBtn.attr("data");
		var curOpe=$("#namedFriendInput");
		$.ajax({
			url:"${appPath}/friend/namedfriend",
			type:"POST",
			data:{"name":curOpe.val(),"friendId":friendId},
			success:function(result){
				if(result.code==1){
					$("#namedFriendModal").modal("hide");
				}else{
					jqueryAlert({'content' : result.msg, 'closeTime' : 1000});
				}
			}
		});
	});
	
	
	/* 点击删除好友 */
	$("body").on("click",".deleteBtn",function(){
		var curOpe=$(this);
		$.ajax({
			url:"${appPath}/friend/deletefriend",
			type:"GET",
			data:{"friendId":curOpe.attr("data")},
			success:function(result){
				if(result.code==1){
					curOpe.parents("tr").remove();
				}else{
					jqueryAlert({'content' : result.msg,'closeTime' : 1000});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert("ok");
			}
		});
	});
	
	/* 点击黑名单 */
	$("body").on("click",".blackBtn",function(){
		/* ajax成功回调函数success当中使用$(this)和下面一行代码中的$(this)不是同一个东西 */
		var blackBtn=$(this);
		$.ajax({
			url:"${appPath}/friend/black",
			type:"GET",
			data:{
				"friendId":$(this).attr("data")
			},
			success:function(result){
				if(result.content.fIsblack==0){
					blackBtn.children("span").removeClass("glyphicon glyphicon-minus-sign").addClass("glyphicon glyphicon-plus-sign");
				}else{
					blackBtn.children("span").removeClass("glyphicon glyphicon-plus-sign").addClass("glyphicon glyphicon-minus-sign");
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert(textStatus);
			}
		});
	});
	
	/* 点击好友管理 */
	$("#friendManage").click(function(){
		$("#friendDiv").show().siblings().hide();
		getFriend();
	});
	
	/* 搜索好友 */
	$("#searchButton").click(function(){
		var friendAcct=$("#searchText").val();		
		/* 如果输入是否为空 */
		if(friendAcct.trim().length==0){
			jqueryAlert({'content' : '请输入好友账号','closeTime' : 2000});
		}else{
			$.ajax({
				url:"${appPath}/member/findfriend",
				data:{
					"friendAcct":friendAcct
				},
				type:"GET",
				success:function(result){
					if(result.code==1){
						var addBtn=$("<a id='confirmAdd' class='btn btn-default btn-xs' href='#' role='button' shid='"+result.content.mId+"'>添加</a>");
						$("#resultSpan").text(result.content.mAccountname+" ").attr("acct",result.content.mAccountname).append(addBtn);
					}else{
						$("#resultSpan").text(result.msg);
					}
					$("#searchResult").show();
				},
				error:function(XMLHttpRequest,textStatus){
					alert("error:"+textStatus);
				}
			});
		}
	});
	
	/* 确认添加好友 */
	$("body").on("click","#confirmAdd",function(){
		var friendId=$("#confirmAdd").attr("shid");
		var friendAcct=$("#resultSpan").attr("acct");
		$.ajax({
			url:"${appPath}/friend/confirmadd",
			type:"GET",
			data:{
				"friendId":friendId,
				"friendAcct":friendAcct
			},
			success:function(result){
				$("#searchResult").hide();
				jqueryAlert({'content' : result.msg,'closeTime' : 2000});
			},
			error:function(XMLHttpRequest,textStatus){
				alert("error");
			}
		});
	});
	
	
	/* 获取留言回复 */
	function getReplyMessage(mId){
		$.ajax({
			url:"${appPath}/message/getreplymessage",
			type:"get",
			data:{"mId":mId},
			success:function(result){
				if(result.code==1){
					console.log(result.content);
					var a="#"+result.content[0].mReplyReferto;
					/* console.log(result.content[0].mId); */
					$(a).children("a:first").before("<br><br>&emsp;&emsp;我的回复：");
					$.each(result.content,function(index,element){
						var replyDiv=$("<p><br>&emsp;&emsp;&emsp;&emsp;"+this.mReplyContent+"</p>");
						$(a).children("a:first").before(replyDiv);
					});
				}
			}
		});
	}
	
	/* 点击留言管理 */
	$("#messageManage").click(function(){
		$("#mymessageDiv").show().siblings().hide();
		$.ajax({
			url:"${appPath}/message/getmymessage",
			type:"get",
			success:function(result){
				console.log(result);
				$.each(result.content,function(){
					var messagediv=$("<div id='"+this.mId+"'></div>");
					var friendacct=$("<strong>"+this.mSponsor+"</strong>");
					var createtime=$("<div align='right'>"+getdate(this.mCreatetime)+"</div>");
					var ope=$("<br><a href='#' mSponsor='"+this.mSponsor+"' mId='"+this.mId+"' class='messagereply'>回复 </a><a href='#' mId='"+this.mId+"' class='messagedelete'  style='color: red;'>删除</a>");
					var hr=$("<hr></hr>");
					$("#mymessageDiv").append(messagediv.append(createtime).append(friendacct).append("对你说：").append(this.mContent).append(ope).append(hr));
					/* 是否有留言回复 */
					getReplyMessage(this.mId); 
				}); 
			},
			error:function(XMLHttpRequest, textStatus){
				alert(textStatus);
			}
		});
	});

	/* 点击添加更多 */
	$("#ifAddMore").click(function(){
		alert("添加更多");
		window.location.href="${appPath}/photo/mulupload";
	});
	
	/* 点击类型管理 */
	$("#typeManage").click(function(){
		getPhotoType("typeOpe");
		$("#typeDiv").show().siblings().hide();
	});

	/* 提交图片 */
	$("#submitPhoto").click(function(){
		$("#submitPhotoForm")[0].submit();
		return false;
	});
	
	/* 点击添加图片类型 */
	$("#addPhototype").click(function(){
		$("#phototype_input").val("");
		$("#addPhotoTypeModal").modal("show");
		$("#confirmSpan").attr("select","").attr("select","add");
	});
	
	/* 确认添加方法 */
	function confirmAddtype(){
		var phototype_input=$("#phototype_input").val();
		/* 进行添加还是修改 */
		var addOrUpdate=$("#confirmSpan").attr("select");
		/* 如果是 修改的话，此项有值，为修改前的名称 */
		var forUpdate=$("#phototype_input").attr("forUpdate");
		$.ajax({
			url:"${appPath}/phototype/addtype",
			type:"GET",
			data:{
				"pTypename":phototype_input,
				"addOrUpdate":addOrUpdate,
				"forUpdate":forUpdate
			},
			success:function(result){
				if(result.code==1){
					/* 成功添加图片类型，才关闭模态框 */
					$("#addPhotoTypeModal").modal('hide');
					/* 刷新图片类型展示 */
					getPhotoType("typeOpe");
				}else{
					/* 添加失败，提示错误信息 */
					$("#phototype_span").text(result.msg);
				}
			},
			error:function(XMLHttpRequest, textStatus){
				alert(textStatus);
			}
		});
	}
	
	/* 点击确认添加按钮 */
	$("#confirmAddType").click(function(){
		confirmAddtype();
	});
	
	/* 聚焦添加类型框 */
	$("#phototype_input").focus(function(){
		$(this).val("").next().empty();
	});
	
	/* 点击单个删除按钮 */
	$("body").on("click", ".deletetype", function() {
		var pId = $(this).attr("pId");
		$.ajax({
			url : "${appPath}/phototype/deletephototype",
			type : "GET",
			data : {
				"pId" : pId
			},
			success : function(result) {
				if (result.code == 1) {
					/* 刷新图片类型展示 */
					getPhotoType("typeOpe");
				} else {
					jqueryAlert({'content' : result.msg,'closeTime' : 2000});
				}
			},
			error : function(XMLHttpRequest, textStatus) {
				alert('删除失败，请重试');
			}
		});
	});

	/* 点击编辑按钮 */
	$("body").on("click", ".edittype", function() {
		var pId = $(this).attr("pId");
		var oldTypename=$(this).parent().prev().text();
		$("#phototype_input").val(oldTypename);
		$("#phototype_input").attr("forupdate","").attr("forupdate",oldTypename);
		$("#addPhotoTypeModal").modal("show");
		$("#confirmSpan").attr("select","").attr("select","update");
	})
	
	/* 点击注销 */
	$("#logout").click(function(){
		window.location.href="${appPath}/member/logout";
	});
	
	/* 点击我的资料 */
	$("#myInfo").click(function(){
		/* 填充可以修改的数据到资料模态框 */
		$("#myNickName").val("${curMember.mNickname}");
		$("#mySignature").val("${curMember.mSignature}");
		$("#myEmail").val("${curMember.mEmail}");
		$("#myInfoModal").modal("show");
	});
	
	/* 点击提交我的资料 */
	$("#submitMyInfo").click(function(){
		$.ajax({
			url:"${appPath }/member/myinfo",
			type:"POST",
			data:$("#myInfoForm").serialize(),
			success:function(result){
				if(result.code==1){
					$("#myInfoModal").modal('hide');
					jqueryAlert({'content' : result.msg,'closeTime' : 2000});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert('更新失败');
			}
		});
		return false;
	});
	
	/* 点击修改密码按钮 */
	$("#updatePassword").click(function(){
		$("#update_password_modal").modal("show");
	});
	
	/* 点击发送验证码 样式的处理真让人恶心 烦烦烦*/
	$("#get_validate_code").click(function(){
		
		/* 发送请求 */
		$.ajax({
			url:"${appPath}/member/sendvalidate",
			type:"GET",
			success:function(result){
				if(result.code==1){
					jqueryAlert({'content' : '发送验证码成功','closeTime' : 2000});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert(textStatus);
			}
		});
		
		/* 时间剩余显示 */
		$("#time_show").show();
		/* 发送验证码禁止点击 */
		$("#get_validate_code").hide();
		var time=60;
		/* 定时任务 */
		var setInt=setInterval(function(){
			/* 如果没有时间剩余 */
			if(time==0){
				/* 移除禁止点击 */
				$("#get_validate_code").text("重新发送验证码").show();
				/* 时间清空 */
				$("#left_time").text("").parent().hide();
				/* 重新设定时间 */
				time=60;
				/* 清除定时任务 */
				clearInterval(setInt);
				/* 让验证码失效 */
				$.get("${appPath}/member/removevalidate");
				/* 必须要返回 false，否则执行下面设置时间代码 */
				return false;
			}
			/* 每秒更新时间 */
			$("#left_time").text(time--);
		},1000);
		/* 禁用默认提交 */
		return false;
	});
	
	/* 点击确认修改密码 */
	$("#comfirm_update_password").click(function(){
		/* 清空错误信息 */
		$(".errorInfo").text("");
		
		/* 验证修改密码表单 */
		if($("#old_password").val().length==0){
			$("#old_password").next().text("旧密码不能为空");
			return false;
		}
		
		if($("#old_password").val().length<6){
			$("#old_password").next().text("旧密码长度太短");
			return false;
		}
		
		if($("#new_password").val().length==0){
			$("#new_password").next().text("新密码不能为空");
			return false;
		}
		
		if($("#new_password").val().length<6){
			$("#new_password").next().text("新密码长度太短");
			return false;
		}
		
		if($("#confirm_password").val().length==0){
			$("#confirm_password").next().text("确认密码不能为空");
			return false;
		}
		
		if($("#old_password").val()==$("#new_password").val()){
			$("#new_password").next().text("新密码和旧密码不能一致");
			return false;
		}
		
		/* 必须是复杂密码：包含英文  数组  特殊字符 */
		var regex = new RegExp('(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,30}');
		if(!regex.test($("#new_password").val())){
			$("#new_password").next().text("密码太简单了，必须包含英文  数字 特殊字符");
			return false;
		}
	
		if($("#confirm_password").val().length<6){
			$("#confirm_password").next().text("确认密码长度太短");
			return false;
		}
		if($("#new_password").val()!=$("#confirm_password").val()){
			$("#confirm_password").next().text("两次密码不一致");
			return false;
		}
		
		/* 如果验证码为空 */
		if($("#validate_code").val().length==0){
			$("#validate_code").next().text("验证码不能为空");
			return false;
		}
		
		/* 验证码格式 */
		var regex = new RegExp('[0-9]{6}');
		if(!regex.test($("#validate_code").val())){
			$("#validate_code").next().text("验证码格式错误，只能为6位数字");
			return false;
		}
		
		$.ajax({
			url:"${appPath}/member/comfirmUpdatePassword",
			type:"GET",
			data:$("#update_password_form").serialize(),
			success:function(result){
				if(result.code==1){
					$("#update_password_modal").modal("hide");
					jqueryAlert({'content' : result.msg,'closeTime' : 1500});
					setTimeout(function(){
						window.location.href="http://localhost:8080/CoolAlbum/";
					},1500);
				}else{
					$("#update_password_span").text(result.msg);
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert('更新失败，发生未知错误');
			}
		});
	});
	
	
	/* 点击给好友留言 */
	var E = window.wangEditor;
	var editor = new E('#multitext');
	editor.create();
	$("#leaveMessage").click(function(){
		$(this).hide();
	    $("#messageSubmit").attr("friendId",friendId);
		$("#messageDiv").show();
	});
	
	/* 点击提交留言 */
	$("#messageSubmit").click(function(){
		$.ajax({
			url:"${appPath}/message/givenmessage",type:"POST",
			data:{"friendId":$(this).attr("friendId"),"message":editor.txt.text()},
			success:function(result){
				jqueryAlert({'content' : result.msg,'closeTime' : 1500});
				editor.txt.text("");
			},
			error:function(XMLHttpRequest,textStatus){alert('留言失败');}
		});
	});
	
	/* 留言删除 */
	$("body").on("click", ".messagedelete", function() {
		var cur=$(this);
		$.ajax({
			url:"${appPath}/message/deletemessage",
			data:{"mId":$(this).attr("mId")},
			success:function(result){
				if(result.code==1){
					cur.parent().empty();
				}
			}
		});
	});
	
	/* 点击留言回复 */
	var replyeditor=null;
	var curReply=null;
	$("body").on("click", ".messagereply", function() {
		
		curReply=$(this);
		
		/* 让当前回复按钮和删除按钮隐藏，富文本框显示，并让其他留言的回复按钮和删除按钮显示，富文本框隐藏 */
		$(this).hide().next().hide().parent().siblings().children("a").show();
		$(this).hide().next().hide().parent().siblings().children("div").remove();
		$("#replytext").empty();
		
		var replyDiv=$("<div id='replytext'></div>");
		var replyMultiDiv=$("<div id='replyMultiDiv'></div>");
		var replyButton=$("<br><a id='replyCancleButton' href='#'class='btn btn-default'>取消</a> <a id='replyButton' href='#' mId='"+curReply.attr("mId")+"' class='btn btn-primary'>提交 </a>");
		replyDiv.append(replyMultiDiv).append(replyButton).insertBefore(this);
		
		var E = window.wangEditor;
		replyeditor = new E('#replyMultiDiv');
		replyeditor.create();
	});
	
	
	/* 点击取消留言 */
	$("body").on("click", "#replyCancleButton", function() {
		$(this).parent().hide().siblings().show();
	});
	
	/* 点击提交回复留言 */
	$("body").on("click", "#replyButton", function() {
		var curReplyButton=$(this);
		$.ajax({
			url:"${appPath}/message/messagereply",
			data:{"mSponsor":curReply.attr("mSponsor"),"replyMessage":replyeditor.txt.text(),"mId":curReplyButton.attr("mId")},
			success:function(result){
				if(result.code==1){
					curReplyButton.parent().hide().nextAll().show();
					jqueryAlert({'content' : result.msg,'closeTime' : 1500});
				}else{
					alert(result.msg);
				}
			}
		});
	});
</script>
</html>