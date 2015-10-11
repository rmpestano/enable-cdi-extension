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
        cdiContainer = CdiContainerLoader.getCdiContainer();
    }


    @Override
    protected Statement withBeforeClasses(Statement originalStatement) {
        cdiContainer.boot();
        Statement statement = super.withBeforeClasses(originalStatement);

        return statement;
    }

    @Override
    protected Statement withAfterClasses(Statement originalStatement) {
        Statement statement = super.withAfterClasses(originalStatement);
        cdiContainer.shutdown();
        return statement;
    }

    @Override
    protected Object createTest() throws Exception {
        return BeanProvider.getContextualReference(getTestClass().getJavaClass(), false);
    }



}
