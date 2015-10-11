package org.jboss.arquillian.enablecdi;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

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
        Object ref = null;
        try {
            ref = BeanProvider.getContextualReference(getTestClass().getJavaClass(), true);
        } catch (Exception e) {
            // not in a container, not in a bean archive
        }
        if (ref == null){
            return super.createTest();
        }
        return ref;
    }



}
