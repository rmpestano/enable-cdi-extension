package org.jboss.arquillian.enablecdi.extension.client;

import org.jboss.arquillian.container.test.spi.client.deployment.ApplicationArchiveProcessor;
import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.core.spi.LoadableExtension;

/**
 * Created by pestano on 11/10/15.
 */
public class EnableCdiExtension implements LoadableExtension {


    public void register(ExtensionBuilder extensionBuilder) {
       extensionBuilder.service(AuxiliaryArchiveAppender.class, EnableCdiAuxiliaryArchive.class);
       //extensionBuilder.service(TestEnricher.class, EnableCdiEnricher.class);
    }
}
