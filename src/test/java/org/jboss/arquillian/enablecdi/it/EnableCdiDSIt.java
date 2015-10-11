package org.jboss.arquillian.enablecdi.it;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.jboss.arquillian.enablecdi.exception.CustomException;
import org.jboss.arquillian.enablecdi.interceptor.Throw;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by pestano on 11/10/15.
 */
@RunWith(CdiTestRunner.class)
public class EnableCdiDSIt {

    @Test(expected = CustomException.class)
    @Throw(exception = CustomException.class)
    public void shouldInterceptThisMethod(){
        Assert.fail();//should not reach here
    }
}
