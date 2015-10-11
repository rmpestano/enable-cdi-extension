package org.jboss.arquillian.enablecdi.extension.client;

import org.jboss.arquillian.core.api.Instance;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.enablecdi.api.EnableCdi;
import org.jboss.arquillian.test.spi.TestEnricher;
import org.jboss.arquillian.testenricher.ejb.EJBInjectionEnricher;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.Context;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by pestano on 11/10/15.
 */
public class EnableCdiEnricher implements TestEnricher {

    private static final Logger log = Logger.getLogger(TestEnricher.class.getName());

    @Inject
    private Instance<BeanManager> beanManagerInstance;

    public void enrich(Object testCase) {

            try
            {
                if(testCase.getClass().isAnnotationPresent(EnableCdi.class) && beanManagerInstance.get() != null)
                {
                    injectClass(testCase);
                }
            }
            catch(Exception e)
            {
                log.throwing(EnableCdiEnricher.class.getName(), "enrich", e);
            }

    }

    private void injectClass(Object testCase) {
        BeanManager beanManager = beanManagerInstance.get();

        Set<Bean<?>> beans = beanManager.getBeans(testCase.getClass());
        Bean<Object> bean = (Bean<Object>) beanManager.resolve(beans);
        CreationalContext<Object> creationalContext = beanManager.createCreationalContext(bean);
    }



    public Object[] resolve(Method method) {
        return new Object[0];
    }
}
