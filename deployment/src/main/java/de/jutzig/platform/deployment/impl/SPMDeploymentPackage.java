package de.jutzig.platform.deployment.impl;

import java.net.URL;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;
import org.osgi.service.deploymentadmin.BundleInfo;
import org.osgi.service.deploymentadmin.DeploymentException;
import org.osgi.service.deploymentadmin.DeploymentPackage;

public class SPMDeploymentPackage implements DeploymentPackage {

	public boolean isStale() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Version getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public BundleInfo[] getBundleInfos() {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	public Bundle getBundle(String symbolicName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getResources() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceReference getResourceProcessor(String resource) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getHeader(String header) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getResourceHeader(String resource, String header) {
		// TODO Auto-generated method stub
		return null;
	}

	public void uninstall() throws DeploymentException {
		// TODO Auto-generated method stub

	}

	public boolean uninstallForced() throws DeploymentException {
		// TODO Auto-generated method stub
		return false;
	}

}
