package com.kkkitsch.coolalbum.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.kkkitsch.coolalbum.entity.TMessage;
import com.kkkitsch.coolalbum.util.MyMsg;

@Aspect
@Component
public class MessageValidAspect {

	@Pointcut(value = "execution(public * com.kkkitsch.coolalbum.service.imp.TMessageServiceImpl.putMessage(..))")
	public void pointcut() {
	}

	@Around(value = "pointcut()")
	public MyMsg<TMessage> putMessageOpe(ProceedingJoinPoint point) {
		// 获取形参
		Object[] args = point.getArgs();

		// 如果要发送的数据中包含不良信息就屏蔽
		for (int i = 0; i < args.length; i++) {
			if (args[i].toString().contains("傻逼")) {
				args[i] = args[i].toString().replace("傻逼", "**");
			}
		}
		try {
			// 执行目标方法
			return (MyMsg<TMessage>) point.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

}
