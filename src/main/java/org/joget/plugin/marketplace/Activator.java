package org.joget.plugin.marketplace;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.ArrayList;
import java.util.Collection;

public class Activator implements BundleActivator {

    protected Collection<ServiceRegistration> registrationList;

    public void start(BundleContext context) {
        registrationList = new ArrayList<ServiceRegistration>();

        //Register plugin here
        registrationList.add(context.registerService(OpenIDDirectoryManagerForUAEPass.class.getName(), new OpenIDDirectoryManagerForUAEPass(), null));
        registrationList.add(context.registerService(ExtUserSecurityImpl.class.getName(), new ExtUserSecurityImpl(), null));
    }

    public void stop(BundleContext context) {
        for (ServiceRegistration registration : registrationList) {
            registration.unregister();
        }
    }
}