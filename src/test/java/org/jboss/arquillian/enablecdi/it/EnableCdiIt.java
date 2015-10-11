package org.jboss.arquillian.enablecdi.it;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.enablecdi.EnableCdiTestRunner;
import org.jboss.arquillian.enablecdi.exception.CustomException;
import org.jboss.arquillian.enablecdi.interceptor.Throw;
import org.jboss.arquillian.enablecdi.interceptor.ThrowInterceptor;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by pestano on 10/10/15.
 */
@RunWith(EnableCdiTestRunner.class)
public class EnableCdiIt {

    @Deployment(name = "test.war")
    public static Archive<?> createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class);
        war.addPackage(ThrowInterceptor.class.getPackage());
        war.addClass(CustomException.class);
        war.addClass(EnableCdiIt.class);
        //war.addAsResource("beans.xml", "META-INF/beans.xml");
        war.addAsWebInfResource("beans.xml", "beans.xml");
        System.out.println(war.toString(true));
        return war;
    }


    @Test(expected = CustomException.class)
    @Throw(exception = CustomException.class)
    public void shouldInterceptThisMethod(){
        Assert.fail();//should not reach here
    }


}
