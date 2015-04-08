package de.jutzig.platform.deployment.impl;

import java.io.InputStream;

import org.osgi.service.deploymentadmin.spi.DeploymentSession;
import org.osgi.service.deploymentadmin.spi.ResourceProcessor;
import org.osgi.service.deploymentadmin.spi.ResourceProcessorException;

public class SPMResourceProcessor implements ResourceProcessor {

	public void begin(DeploymentSession session) {
		// TODO Auto-generated method stub

	}

	public void process(String name, InputStream stream)
			throws ResourceProcessorException {
		// TODO Auto-generated method stub

	}

	public void dropped(String resource) throws ResourceProcessorException {
		// TODO Auto-generated method stub

	}

	public void dropAllResources() throws ResourceProcessorException {
		// TODO Auto-generated method stub

	}

	public void prepare() throws ResourceProcessorException {
		// TODO Auto-generated method stub

	}

	public void commit() {
		// TODO Auto-generated method stub

	}

	public void rollback() {
		// TODO Auto-generated method stub

	}

	public void cancel() {
		// TODO Auto-generated method stub

	}

}
