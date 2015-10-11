package org.jboss.arquillian.enablecdi.interceptor;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;
import java.util.logging.Level;

/**
 * Created by pestano on 10/10/15.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@InterceptorBinding
public @interface Throw {

    @Nonbinding
    Class<? extends RuntimeException> exception() default RuntimeException.class;

    @Nonbinding
    String cause() default "";
}
