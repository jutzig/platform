package de.jutzig.platform;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import com.vaadin.server.VaadinServlet;


@Component(immediate = true)
@Service
public class StaticResources implements HttpContext, BundleListener {
	private static final String RESOURCE_BASE = "/VAADIN";
	
	@Property(name="http.alias",value="/VAADIN")
	public String alias = "/VAADIN";
	
	private Set<Bundle> resourceBundles = new HashSet<Bundle>();


	@Reference(bind="setHttpService", unbind = "unsetHttpService", policy=ReferencePolicy.DYNAMIC, cardinality=ReferenceCardinality.OPTIONAL_MULTIPLE)
	private HttpService httpService;
	
	public void setHttpService(final HttpService httpService)
			throws NamespaceException {
		httpService.registerResources(RESOURCE_BASE, RESOURCE_BASE, this);
	}

	@SuppressWarnings("unused")
	private void unsetHttpService(final HttpService httpService) {
		httpService.unregister(RESOURCE_BASE);
	}

	@Override
	public boolean handleSecurity(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return true;
	}

	@Override
	public URL getResource(final String name) {
//		return VaadinServlet.class.getClassLoader().getResource(name);
		URL resource = null;
//		String uri = "/" + name;
		for (Bundle bundle : resourceBundles) {
			String root = (String) bundle.getHeaders().get("Vaadin-Resources");
//			if (!".".equals(root)) {
//				uri = "/" + root + uri;
//			}
			if (null != (resource = bundle.getResource(name))) {
				return resource;
			}
		}
		resource = PlatformUI.class.getResource(name);
		if (null != resource) {
			return resource;
		}
		return null;
	}

	@Override
	public String getMimeType(final String name) {
		URL resource = getResource(name);
		if (null != resource) {
			try {
				return resource.openConnection().getContentType();
			} catch (final IOException e) {
				return null;
			}
		}
		return null;
	}

	private void checkBundleForResources(Bundle bundle) {
		if(bundle.getSymbolicName().contains("vaadin")) {
//		if (null != bundle.getHeaders().get("Vaadin-Resources")) {
			resourceBundles.add(bundle);
		} else {
			resourceBundles.remove(bundle);
		}
	}

	@Override
	public void bundleChanged(BundleEvent event) {
		if (event.getType() == BundleEvent.UNINSTALLED) {
			resourceBundles.remove(event.getBundle());
		} else {
			checkBundleForResources(event.getBundle());
		}
	}

	@Activate
	public void start(BundleContext ctx) {
		ctx.addBundleListener(this);
		for (Bundle bundle : ctx.getBundles()) {
			checkBundleForResources(bundle);
		}
	}
	
	
}