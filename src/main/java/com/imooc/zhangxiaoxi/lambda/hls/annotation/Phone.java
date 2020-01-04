package com.imooc.zhangxiaoxi.lambda.hls.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author huangliusong
 * @since 2020/1/4
 * {@link }
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//不同之处：于约束注解关联的验证器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    // 信息
    String message() default "手机号验证错误";

    //组
    Class<?>[] groups() default {};

    //约束注解的有效负载
    Class<? extends Payload>[] playload() default {};
}
