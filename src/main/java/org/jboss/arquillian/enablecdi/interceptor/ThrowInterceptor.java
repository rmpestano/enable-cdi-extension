package org.jboss.arquillian.enablecdi.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by pestano on 10/10/15.
 */
@Interceptor
@Throw
public class ThrowInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext invocationContext)
            throws Exception {

        Throw ex = null;
        if (invocationContext.getMethod().isAnnotationPresent(Throw.class)) {
            ex = invocationContext.getMethod().getAnnotation(Throw.class);
        } else if (invocationContext.getMethod().getDeclaringClass().isAnnotationPresent(Throw.class)) {
            ex = invocationContext.getMethod().getDeclaringClass().getAnnotation(Throw.class);
        } else {
            throw new RuntimeException("How did you reach here?");
        }

        RuntimeException runtimeException = ex.exception().newInstance();
        String cause = ex.cause();
        if (!"".equals(cause)) {
            runtimeException.initCause(new Throwable(cause));
        }
        throw runtimeException;

    }
}
