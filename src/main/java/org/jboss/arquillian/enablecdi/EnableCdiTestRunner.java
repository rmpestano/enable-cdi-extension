package org.jboss.arquillian.enablecdi;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.testenricher.cdi.container.CDIExtension;
import org.junit.runners.model.InitializationError;

/**
 * Created by pestano on 11/10/15.
 */
public class EnableCdiTestRunner extends Arquillian {

    protected CdiContainer cdiContainer;

    public EnableCdiTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }



    @Override
    protected Object createTest() throws Exception {
        BeanManager beanManager = CDIExtension.getBeanManager();

        Class<?> type = getTestClass().getJavaClass();

        Object result;
        if (beanManager == null)
        {
            result = super.createTest();
        }
        else
        {
            Set<Bean<?>> beans = beanManager.getBeans(type);
            Bean<Object> bean = (Bean<Object>) beanManager.resolve(beans);
            CreationalContext<Object> creationalContext = beanManager.createCreationalContext(bean);
            result = beanManager.getReference(bean, type, creationalContext);
        }
        return result;
    }



}
