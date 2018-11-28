<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的个人中心</title>

<%@include file="/WEB-INF/common/js-css-file.jsp"%>

</head>

<body>
	<div class="container">
	
		<!-- 栅格开始  -->
		<div class="row">
	
			<!--栅格占用2 偏移10 -->
			<div class="col-md-2">
	
				<!-- 下拉菜单 -->
				<div class="dropdown">
					
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						${curMember.mNickname } 
						<span class="caret"></span>
					</button>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<br>
						<li><a id="myInfo" href="#">我的资料</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">修改密码</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="logout" href="#">注销</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 顶部栅格结束 -->

		<!-- 栅格系统开始 -->
		<div class="row">
			<!-- 菜单 -->
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked">
					<li id="uploadFile" role="presentation"><a href="#">上传图片</a></li>
					<li id="scanFile" role="presentation"><a href="#">浏览图片</a></li>
					<li id="messageManage" role="presentation"><a href="#">留言管理</a></li>
					<li id="typeManage" role="presentation"><a href="#">类型管理</a></li>
				</ul>
			</div>
			
			<!-- 内容 -->
			<div class="col-md-10">
				
				<div id="contentDiv">新的一天 新的sang</div>

				<div class="col-md-5" id="uploadDiv">
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
				
				<div id="scanDiv">
				</div>
				
				<div id="messageDiv">消息</div>
				
				<div id="typeDiv">
					
					<!-- 按钮 -->
					<div class="row">
						<div class="col-md-3 col-md-offset-9">
							<button id="addPhototype" type="button" class="btn btn-info">添加类型</button>
							<button id="partDeletetype" type="button" class="btn btn-warning">选择删除</button>
						</div>
					</div>
					
					<br>
					
					<!-- 警告框 -->
					<div class="row">
						<div class="col-md-10">
							<div class="alert alert-warning alert-danger" role="alert">
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
								<td>id</td>
								<td>名称</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody id="typdBody">
						</tbody>
					</table>	
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
					<div class="row">
						<div>
							<div class="col-md-8">
								<img id="pd_img" src="" class="img-responsive" alt="Responsive image">
							</div>
							<div class="col-md-4">
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
									<label>描述</label> 
									<p id="pd_detail"></p>
								</div>
							</div>
						</div>
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
			var tdPid=$("<td></td>").append(this.pId);
			var tdPTypename=$("<td></td>").append(this.pTypename);
			
			/* 操作 按钮 */
			var editBtn=$("<button type='button' pId='"+this.pId+"' class='btn btn-primary btn-sm edittype'>编辑</button>");
			var delBtn=$("<button type='button' pId='"+this.pId+"' class='btn btn-danger btn-sm deletetype'>删除</button>");
			var tdOpeBtn=$("<td></td>").append(editBtn).append(" ").append(delBtn);
			
			/* 填充  */
			tr.append(tdCheck).append(tdPid).append(tdPTypename).append(tdOpeBtn);
			$("#typdBody").append(tr);
		});
	}
	
	/* 图片类型 */
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
					if(selection=="fill"){
						/* 如果是上传 */
						fillToUploadForm(result);
					}else if(selection=="typeOpe"){
						/* 如果是编辑 */
						fillToPhototypeOpe(result);
					}else if(selection=="pd_detail"){
						/* 如果是查看图片详情*/
						photo_type=result;
						console.log("result作为公共资源啦");
					}else{
						/* 出错了 */
						jqueryAlert({
						    'content' : '错误',
						    'closeTime' : 2000
						});
					}
				}else{
					/* 查询无结果 */
					var tipMessage=$("<h2></h2>").text("一个分类也没有......");
					$("#typdBody").empty().append(tipMessage);
				}
			},
			error:function(XMLHttpRequest, textStatus){
				jqueryAlert({
				    'content' : '获取图片类型失败，请重试',
				    'closeTime' : 2000
				});
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
		
		/* 追加填充 */
		var rowDiv=$("<div class='row'></div>");
		$.each(result.content,function(index){
			var imgUrl="${appPath}/"+this.pUrl;
			var img=$("<img src='"+imgUrl+"' style='height: 200px;width: 200px;'></img>");
			var span=$("<span></span>").text(this.pName);
			var a=$("<a href='#' class='thumbnail'></a>").append(img);
			
			/* 图片操作按钮 */
			var like=$("<a  href='#' pId='"+this.pId+"'class='btn btn-default iflike'>点赞</a>");
			var detail=$("<a href='#' pId='"+this.pId+"' class='btn btn-default photoDetail' role='button'>详情</a>");
			var singleDelete=$("<a href='#' pId='"+this.pId+"' class='btn btn-default singleDelete' role='button'>删除</a>");
			var opeBtn=$("<p></p>").append(like).append(" ").append(detail).append(" ").append(singleDelete);
			
			var div=$("<div class='col-md-3'></div>").append(span).append(a).append(opeBtn);
			rowDiv.append(div);
		});
		$("#scanDiv").append(rowDiv);
	}
	
	/* 查询后得到的图片信息，方便以后使用，作为变量 */
	var photo_msg;
	
	/* 点击浏览按钮 */
	$("#scanFile").click(function(){
		$("#scanDiv").show().siblings().hide();
		$.ajax({
			url:"${appPath}/photo/getAllPhoto",
			type:"GET",
			success:function(result){
				/* 成功 */
				if(result.code==1){
					/* 给变量一份 */
					photo_msg=result;
					
					/* 填充图片信息 */
					fill_photo(result);
				}else{
					jqueryAlert({
					    'content' : '一个图片也没有',
					    'closeTime' : 2000
					});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert(textStatus);
			}
		});
	});
	
	/* 图片点赞点击 */
	$("body").on("click",".iflike",function(){
		
		var pId=$(this).attr("pId");		
		$.ajax({
			url:"${appPath}/photo/clicklike",
			type:"GET",
			data:"pId="+pId,
			success:function(result){
				console.log(result);
				if(result.code==1){
					jqueryAlert({
					    'content' : '点赞成功',
					    'closeTime' : 1000
					});
				}else{
					jqueryAlert({
					    'content' : '点赞失败，可能已经点过赞了！',
					    'closeTime' : 1000
					});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				jqueryAlert({
				    'content' : '发生未知错误！',
				    'closeTime' : 1000
				});
			}
		});
	});
	
	/* 图片详情点击 */
	$("body").on("click",".photoDetail",function(){
		/* 查出所有图片的类型 */
		getPhotoType("pd_detail");
		
		/* 得到当前图片id */
		var pId=$(this).attr("pId");
		$("#photo_detail_modal").modal("show");
		/* 遍历找到当前图片信息填充到模态框 */
		$.each(photo_msg.content,function(index,photo_msg){
			if(pId==this.pId){
				/* 清空填充 */
				$("#pd_img").prop("src","").prop("src","${appPath}/"+this.pUrl);
				$("#pd_name").text("").text(this.pName);
				
				/* 如果不为空，遍历所有类型 */
				if(photo_type!=undefined){
					$.each(photo_type.content,function(index,element_photo_type){
						/* 如果某一个类型和当前图片的类型一致 */
						if(element_photo_type.pId==photo_msg.pTypeId){
							/* 填充此类型到当前图片的详情信息 */
							$("#pd_type").text("").text(element_photo_type.pTypename);
						}
					});
				}
				$("#pd_createtime").text("").text(new Date(this.pCreatetime));
				$("#pd_detail").text("").text(this.pDescription);
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
					
					jqueryAlert({
					    'content' : '删除成功！',
					    'closeTime' : 1000
					});
				}else{
					jqueryAlert({
					    'content' : '删除失败！',
					    'closeTime' : 1000
					});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				alert("error");
			}
		});
	});
			
	/* 点击留言管理 */
	$("#messageManage").click(function(){
		$("#messageDiv").show().siblings().hide();
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
				console.log(result);
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
					jqueryAlert({
						'content' : '删除失败，请重试',
						'closeTime' : 2000
					});
				}
			},
			error : function(XMLHttpRequest, textStatus) {
				jqueryAlert({
					'content' : '删除失败，请重试',
					'closeTime' : 2000
				});
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
					jqueryAlert({
						'content' : '更新成功',
						'closeTime' : 2000
					});
				}
			},
			error:function(XMLHttpRequest,textStatus){
				jqueryAlert({
					'content' : '更新失败',
					'closeTime' : 2000
				});
			}
		});
		return false;
	});
	
</script>
</html>