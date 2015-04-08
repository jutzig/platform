package de.jutzig.platform.deployment.impl;

import java.io.InputStream;

import org.osgi.framework.Bundle;
import org.osgi.service.deploymentadmin.DeploymentAdmin;
import org.osgi.service.deploymentadmin.DeploymentException;
import org.osgi.service.deploymentadmin.DeploymentPackage;

public class DefaultDeploymentAdmin implements DeploymentAdmin {

	public DeploymentPackage installDeploymentPackage(InputStream in)
			throws DeploymentException {
		// TODO Auto-generated method stub
		return null;
	}

	public DeploymentPackage[] listDeploymentPackages() {
		// TODO Auto-generated method stub
		return null;
	}

	public DeploymentPackage getDeploymentPackage(String symbName) {
		// TODO Auto-generated method stub
		return null;
	}

	public DeploymentPackage getDeploymentPackage(Bundle bundle) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean cancel() {
		// TODO Auto-generated method stub
		return false;
	}

}
