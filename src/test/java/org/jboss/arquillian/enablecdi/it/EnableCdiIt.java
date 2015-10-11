package org.jboss.arquillian.enablecdi.it;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.enablecdi.EnableCdiTestRunner;
import org.jboss.arquillian.enablecdi.api.EnableCdi;
import org.jboss.arquillian.enablecdi.exception.CustomException;
import org.jboss.arquillian.enablecdi.interceptor.Throw;
import org.jboss.arquillian.enablecdi.interceptor.ThrowInterceptor;
import org.jboss.arquillian.testenricher.cdi.container.CDIExtension;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * Created by pestano on 10/10/15.
 */
@RunWith(EnableCdiTestRunner.class)
public class EnableCdiIt {

    @Deployment(name = "test.jar")
    public static Archive<?> createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class);
        jar.addPackage(ThrowInterceptor.class.getPackage());
        jar.addClass(CustomException.class);
        jar.addAsResource("beans.xml", "META-INF/beans.xml");
        //war.addAsWebInfResource("beans.xml", "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }


    @Test(expected = CustomException.class)
    @Throw(exception = CustomException.class)
    public void shouldInterceptThisMethod(){
        Assert.fail();//should not reach here
    }


}
