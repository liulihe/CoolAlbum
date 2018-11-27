<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="submitPhotoForm" action="${appPath }/photo/uploadclick"
		method="post" enctype="multipart/form-data">
		
		<div class="form-group">
			<label>添加相片</label> <input type="file" name="mulFile"
				class="form-control" multiple="multiple">
		</div>
		<input type="submit" value="submit">
	</form>


</body>
</html>