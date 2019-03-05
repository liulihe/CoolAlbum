<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>好友照片</title>
<%@include file="/WEB-INF/common/js-css-file.jsp"%>
</head>
<body>

	<div class="container">
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

	<div class="container">
		<div id="scanDiv"></div>
		<div id="numnav">页面导航栏暂未实现</div>
	</div>

	<hr>

	<script>
		/* 填充图片 */
		function fill_photo(result){
			/* 清空 */
			$("#scanDiv").empty();
			/* 追加填充 */
			var rowDiv=$("<div class='row'></div>");
			$.each(result,function(index){
				var imgUrl="${appPath}/"+this.pUrl;
				var img=$("<img src='"+imgUrl+"' style='height: 200px;width: 200px;'></img>");
				var a=$("<a href='#' class='thumbnail'></a>").append(img);
				
				/* 图片操作按钮 */
				var likespan=$("<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'></span>");
				var like=$("<button type='button' pId='"+this.pId+"' class='btn btn-default iflike' aria-label='Left Align'></button>");
				var detailspan=$("<span class='glyphicon glyphicon-option-horizontal' aria-hidden='true'></span>");
				var detail=$("<a href='#' pId='"+this.pId+"' class='btn btn-default photoDetail' role='button'></a>");
				var opeBtn=$("<p></p>").append(like.append(likespan)).append(" ").append(detail.append(detailspan));
				var div=$("<div class='col-md-3'></div>").append(a).append(opeBtn);
				rowDiv.append(div);
			});
			$("#scanDiv").append(rowDiv);
		}
		
		/* 填充图片类型 */
		function fill_phototype(result){
			$.each(result,function(index){
				$("#phototypeid").append("<option value='"+this.pId+"'>"+this.pTypename+"</option>");
			});
		}
		
		if('${photoMsg}'=="nothing"){
			$("#scanDiv").text("没有照片");
		}else{
			fill_photo(JSON.parse('${photoMsg}'));
		}
	
		if ('${phototype}' == "nothing") {
		} else {
			fill_phototype(JSON.parse('${phototype}'));
		}

		/* 点击图片筛选 */
		$("#photoselect").click(function() {
			var pagesize = $("#photosize").val();
			var phototypeid = $("#phototypeid").val();
			window.location.href = "${appPath}/friend/access?ps="
					+ pagesize + "&phototypeid=" + phototypeid
					+ "&friendId=" + '${friendId}';
		});
	</script>
</body>
</html>