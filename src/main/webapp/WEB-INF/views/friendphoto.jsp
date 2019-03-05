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
				<select class="form-control">
					<option>每页显示10张图片</option>
					<option>每页显示20张图片</option>
					<option>每页显示50张图片</option>
					<option>每页显示100张图片</option>
				</select>
			</div>
			<div class="col-md-3">
				<select class="form-control">
					<option>所有图片</option>
				</select>
			</div>
		</div>
	</div>

	<hr>

	<div class="container">
		<div id="scanDiv"></div>
	</div>

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
		
		fill_photo(JSON.parse('${accessMsg}'));
	</script>
</body>
</html>