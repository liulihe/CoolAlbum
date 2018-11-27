<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量上传</title>

<!-- 批量上传图片插件样式 -->
<script src="${appPath}/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="${appPath }/plugin/upload/css/globle.css" />
<script src="${appPath }/plugin/upload/js/diyUpload.js"></script>
<script src="${appPath }/plugin/upload/js/webuploader.min.js"></script>
<link rel="stylesheet" type="text/css" href="${appPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${appPath}/plugin/alert/css/alert.css" />
<script src="${appPath}/js/bootstrap.min.js"></script>

</head>
<body class="">

	<form id="submitMulPhotoForm" action="${appPath }/photo/submitupload" method="post" enctype="multipart/form-data" >
		<div class="row">
			<div class="col-md-6">
				<div style="padding: 100px;">
					<ul class="upload-ul clearfix">
						<li class="upload-pick">
							<div class="webuploader-container clearfix" id="goodsUpload"></div>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-3">
				<br><br><br><br><br>
				<div class="form-group desc">
					<label>相片名称</label> 
					<input type="text" name="pName" class="form-control" placeholder="相册名称">
				</div>
				<div class="form-group desc">
					<label>分类</label> 
					<select id="phototype" name="pTypeId" class="form-control"></select>
				</div>
				<div class="form-group desc">
					<label>相册描述</label> 
					<input type="text" name="pDescription" class="form-control desc" placeholder="相册描述">
				</div>
				<a id="submitMulPhoto" href="#" class="btn btn-success">上传</a>
			</div>
		</div>
	</form>
	
	<script>
	
		/* 页面加载完成 */
		function get_photo_type(result){
			/* 每次填充前先清空 */
			$("#phototype").empty();
			/* 遍历填充图片类型 */
			$.each(result.content,function(){
				$("#phototype").append($("<option value='"+this.pId+"'></option>").append(this.pTypename));
			});
		}
	
		/* 从数据库中查询出所有图片类型，填充到图片分类option */
		$.ajax({
			url:"${appPath}/phototype/gettype",
			type:"GET",
			success:function(result){
				/* 如果查询有结果 */
				if(result.content.length>=1){
					get_photo_type(result);
				}else{
					alert("error");
				}
			}
		});
	
		/* 点击上传 */
		$("#submitMulPhoto").click(function(){
			alert($(".diyControl").length);
			window.location.href="${appPath}/photo/uploadclick";
		});
		
		/* 默认处理 */
		$(function() {
			//上传图片
			var $tgaUpload = $('#goodsUpload').diyUpload({
				url : '${appPath}/photo/uploadclick',
				success : function(data) {
					alert("结果："+data);
				},
				error : function(err) {
					alert("错误结果："+data);
				},
				buttonText : '',
				accept : {
					title : "Images",
					extensions : 'gif,jpg,jpeg,bmp,png'
				},
				thumb : {
					width : 120,
					height : 90,
					quality : 100,
					allowMagnify : true,
					crop : true,
					type : "image/jpeg"
				}
			});
		});
	</script>
</body>
</html>