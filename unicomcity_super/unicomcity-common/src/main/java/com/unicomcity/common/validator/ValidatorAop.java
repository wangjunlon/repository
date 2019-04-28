package com.unicomcity.common.validator;

import com.unicomcity.common.controller.MessageObject;
import com.unicomcity.common.controller.MessageUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component // 加入到IoC容器
@Aspect // 指定当前类为切面类
public class ValidatorAop {
	@Autowired
	protected Validator validator;
	@Pointcut("execution(public * com.unicomcity.*.controller.*Controller.*(..))")
	public void pointCut() {

	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Parameter[] parameters = method.getParameters();
		if (parameters != null && parameters.length > 0) {
			for (int j = 0; j < parameters.length; j++) {
				Parameter parameter = parameters[j];
				Validate validate = parameter.getAnnotation(Validate.class);// 获取参数的注解
				if (validate != null) {
					Class valiclass = validate.valiclass();
					MessageObject messageObject =  MessageUtils.ObectToClass(joinPoint.getArgs()[j].toString(), valiclass);
					Object messageclass = messageObject.getContent();
					Class<?>[] groups = validate.groups();// 获取注解参数，验证组
					String violationErrors =groups.length!=0?beanValidator(messageclass, groups):beanValidator(messageclass);// 参数有效性验证
					if (violationErrors != null) {
						return violationErrors;// 验证不通过，返回结果
					}
				}
			}
		}
		return joinPoint.proceed();
	}


	public String beanValidator(Object object, Class<?>... groups) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			List<MessageObject> list = new ArrayList<>();
			MessageObject messageObject = new MessageObject();
			for (ConstraintViolation<Object> cv : constraintViolations) {
				messageObject = new MessageObject();
				messageObject.setCode("1003");
				messageObject.setContent(cv.getMessageTemplate());
				list.add(messageObject);
			}
			if(list!=null&&list.size()>0){
				MessageObject messageObject_list_one = list.get(0);
				return MessageUtils.ObjectTojson(messageObject_list_one);
			}
		}
		return null;
	}

}