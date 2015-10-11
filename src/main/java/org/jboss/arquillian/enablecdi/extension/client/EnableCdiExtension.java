package org.jboss.arquillian.enablecdi.extension.client;

import org.jboss.arquillian.container.test.spi.client.deployment.ApplicationArchiveProcessor;
import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.test.spi.TestEnricher;

/**
 * Created by pestano on 11/10/15.
 */
public class EnableCdiExtension implements LoadableExtension {


    public void register(ExtensionBuilder extensionBuilder) {
       // extensionBuilder.service(ApplicationArchiveProcessor.class, EnableCdiArchiveProcessor.class);
       // extensionBuilder.service(TestEnricher.class, EnableCdiEnricher.class);
    }
}
