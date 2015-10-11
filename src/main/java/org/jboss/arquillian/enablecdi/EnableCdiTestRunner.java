package org.jboss.arquillian.enablecdi;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.testenricher.cdi.container.CDIExtension;
import org.junit.runners.model.InitializationError;

import javax.enterprise.inject.spi.BeanManager;

/**
 * Created by pestano on 11/10/15.
 */
public class EnableCdiTestRunner extends Arquillian {


    public EnableCdiTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }


    @Override
    protected Object createTest() throws Exception {
        BeanManager beanManager = CDIExtension.getBeanManager();
        //FIXME bean manager is null
        return super.createTest();
    }
}
