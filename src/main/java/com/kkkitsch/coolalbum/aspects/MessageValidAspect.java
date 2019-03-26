package com.kkkitsch.coolalbum.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.kkkitsch.coolalbum.entity.TMessage;
import com.kkkitsch.coolalbum.util.HttpClientUtil;
import com.kkkitsch.coolalbum.util.MyMsg;

@Aspect
@Component
public class MessageValidAspect {

	@Pointcut(value = "execution(public * com.kkkitsch.coolalbum.service.imp.TMessageServiceImpl.putMessage(..))")
	public void pointcut() {
	}

	@Around(value = "pointcut()")
	public MyMsg<TMessage> putMessageOpe(ProceedingJoinPoint point) throws Exception {
		// 获取形参
		Object[] args = point.getArgs();
		// 如果要发送的数据中包含不良信息就屏蔽
		boolean validContent = HttpClientUtil.validContent(args[args.length - 1].toString());
		// 如果有不当信息
		if (!validContent) {
			return MyMsg.fail("留言失败，检测到不当信息，请重新留言", null, null);
		}
		try {
			// 执行目标方法
			return (MyMsg<TMessage>) point.proceed(args);
		} catch (Throwable e) {
			return MyMsg.fail("发生错误，请重试", null, null);
		}
	}
}
