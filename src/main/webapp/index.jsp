<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>欢迎来到电子相册</title>
<%@include file="/WEB-INF/common/js-css-file.jsp" %>
</head>
<body style="background-color: #C7EDCC">
	<div class="row"><br><br><br>
		<div class="col-md-3 col-md-offset-2">
			<div class="layui-card" >
				<div class="layui-card-header"  style="background-color: #C7EDCC"></div>
				<div class="layui-card-header poemauthor"  style="background-color: #C7EDCC"></div>
				<div class="layui-card-body"  style="background-color: #C7EDCC">
				</div>
			</div>
			<script type="text/javascript">
				jinrishici.load(function(result) {
					$(".layui-card-header").text(result.data.origin.title);
					$(".poemauthor").text(result.data.origin.dynasty+" "+result.data.origin.author);
					$(".layui-card-body").text(result.data.content);
				});
			</script>
		</div>
		
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<form id="loginForm" method="post" action="${appPath }/member/login">
					<br> <br> <br> <br> <br>
					
					<!-- 如果有登录失败信息 -->
					<span id="loginErrorMsgSpan" style="color: red;">
						<c:if test="${not empty loginErrorMsg }">${loginErrorMsg }<c:remove var="loginErrorMsg"/></c:if>
					</span>
					<div class="form-group">
						<label>账号</label> 
						<input type="text" name="mAccountname" value="${curMember.mAccountname }" class="form-control" placeholder="请输入账号">
					</div>
					<div class="form-group">
						<label>密码</label> 
						<input type="password" name="mPassword" value="${curMember.mPassword }" class="form-control" placeholder="请输入密码">
					</div>
					<button id="loginButton" type="submit" class="btn btn-success">登录</button>
					还没有账号？立即<a id="registerHref" href="#">注册</a>
				</form>
			<form id="registerForm" action="${appPath }/member/register" method="post">
					<br> <br> <br> 
					
					<!-- 如果有失败信息 -->
					<span id="registerErrorMsgSpan" style="color: red;">
						<c:if test="${not empty registerErrorMsg }">${registerErrorMsg }<c:remove var="registerErrorMsg"/></c:if>
					</span>
					<div class="form-group">
						<label>账号</label> 
						<input type="text" id="accountname_input" name="mAccountname"  value="${curMember.mAccountname }" class="form-control" placeholder="请输入账号">
						<span id="accountname_span" style="color: red;" class="errorInfo"></span>
					</div>
					<div class="form-group">
						<label>密码</label> 
						<input type="password" id="password_input" name="mPassword" class="form-control" placeholder="请输入密码">
						<span id="password_span" style="color: red;" class="errorInfo"></span>
					</div>
					
					<div class="form-group">
						<label>确认密码</label> 
						<input type="password" id="rePassword_input" name="mRePassword" class="form-control" placeholder="请重新输入密码">
						<span id="rePassword_span" style="color: red;" class="errorInfo"></span>
					</div>
					<div class="form-group">
						<label>邮箱</label> 
						<input type="email" id="email_input" name="mEmail" value="${curMember.mEmail }" class="form-control" placeholder="请输入邮箱">
						<span id="email_span" style="color: red;" class="errorInfo"></span>
					</div>
					<div class="form-group">
						<label>手机号</label> 
						<input type="text" id="phone_input" name="mPhone" value="${curMember.mPhone }" class="form-control" placeholder="请输入手机号">
						<span id="phone_span" style="color: red;" class="errorInfo"></span>
					</div>
					<button id="registerButton" type="submit" class="btn btn-success">注册</button>
					已有账号？立即<a id="loginHref" href="#">登录</a>
				</form>
		</div>
	</div>
	<script>
		/* 页面加载完成 */
		$("#registerForm").hide();
		
		/* 如果有注册失败信息 */
		if($("#registerErrorMsgSpan").text().trim().length>=1){
			$("#registerForm").show();
			$("#loginForm").hide();
		}
		
		/* 如果有登录失败信息 */
		if($("#loginErrorMsgSpan").text().trim().length>=1){
			$("#registerForm").hide();
			$("#loginForm").show();
		}
		
		/* 点击注册链接 */
		$("#registerHref").click(function(){
			$("#registerForm").show();
			$("#loginForm").hide();
			return false;
		});
		
		/* 点击登录链接 */
		$("#loginHref").click(function(){
			$("#loginForm").show();
			$("#registerForm").hide();
			return false;
		});
		
		/* 点击登录按钮 */
		$("#loginButton").click(function() {
			$("#loginForm")[0].submit();
			return false;
		});
		
		/* 点击注册按钮 */
		$("#registerButton").click(function(){
			var errorInfo=$(".errorInfo").text();
			/* 如果表单无误 */
			if(errorInfo==undefined|errorInfo.length<1){
				/* 提交表单 */
				$("#registerForm")[0].submit();
			}else{
				/* 表单有误 */
				jqueryAlert({
					'icon' : '${appPath}/plugin/alert/img/error.png',
					'content' : '注册失败，请检查后重新输入',
					'closeTime' : 2000,
				});
			}
			return false;
		});
		
		
		/* 设置校验器的默认规则 */
		$.validator.setDefaults({
			/* 表单提交后的动作 */
			submitHandler : function() {
				jqueryAlert({
					'content' : '提交表单成功',
					'closeTime' : 2000,
				});
			},
			/* 发生错误时，显示错误消息 */
			showErrors : function(map, list) {
				/* 在每次显示错误信息前，先清除掉以前的错误信息和状态  */
				$(".errorInfo").empty();
				$(".form-group").removeClass("has-success has-error has-warning");
				/* 遍历发生错误的元素数组 */
				$.each(list,function(){
					
					/* 将当前元素的错误信息，显示在当前元素的图标下(注：this.element是一个DOM元素) */
					$(this.element).nextAll(".errorInfo").text(this.message);
					/* 元素边框变为红色 */
					$(this.element).parent("div.form-group").addClass("has-error");
				});
			}
			
		});
		
		/* 前端进行注册表单验证 */
		$("#registerForm").validate({
			rules : {
				mAccountname : {
					required : true,
					minlength : 3
				},
				mPassword : {
					required: true,
					minlength : 6
				},
				mRePassword : {
					required: true,
					minlength : 6,
					equalTo:"#password_input"
				},
				mEmail : {
					required : true,
					email : true
				}
			},
			messages : {
				mAccountname : {
					required : "账号不能为空",
					minlength : "账号长度必须是3位以上"
				},
				mPassword : {
					required : "密码不能为空",
					minlength : "密码必须在6位以上"
				},
				mRePassword : {
					required : "重复密码不能为空",
					minlength : "重复密码必须在6位以上",
					equalTo : "两次输入密码不一致"
				},
				mEmail : {
					required : "邮箱不能为空",
					email : "请输入正确的邮箱格式"
				}
			}
		});

		/* 离开手机号输入框 */
		$("#phone_input").blur(function(){
			var pattern = /0?(13|14|15|18|17)[0-9]{9}/;
			var str = $(this).val();
			if(!pattern.test(str)){
				$(this).next().empty().text("手机号不正确");
				$("#registerButton").attr("disabled","disabled");
			}
		});
		
		/* 聚焦到手机号输入框 */
		$("#phone_input").focus(function(){
			$(this).next().empty();
			$("#registerButton").removeAttr("disabled");
		});
		
	</script>
</body>
</html>