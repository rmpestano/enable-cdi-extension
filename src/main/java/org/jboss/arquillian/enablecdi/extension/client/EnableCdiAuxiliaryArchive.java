package org.jboss.arquillian.enablecdi.extension.client;

import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.enablecdi.EnableCdiTestRunner;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public class EnableCdiAuxiliaryArchive implements AuxiliaryArchiveAppender {

    public Archive<?> createAuxiliaryArchive() {
        return ShrinkWrap.create(JavaArchive.class, "arquillian-enable-cdi.jar")
                .addPackages(true, EnableCdiTestRunner.class.getPackage().getName());
    }

}
