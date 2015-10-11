package org.jboss.arquillian.enablecdi.extension.client;

import org.jboss.arquillian.container.test.spi.client.deployment.ApplicationArchiveProcessor;
import org.jboss.arquillian.enablecdi.api.EnableCdi;
import org.jboss.arquillian.test.spi.TestClass;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 * Created by pestano on 11/10/15.
 */
public class EnableCdiArchiveProcessor implements ApplicationArchiveProcessor {


    public void process(Archive<?> archive, TestClass testClass) {

         if(testClass.isAnnotationPresent(EnableCdi.class)){
             ((JavaArchive)archive).addClass(testClass.getJavaClass());
         }
    }
}
