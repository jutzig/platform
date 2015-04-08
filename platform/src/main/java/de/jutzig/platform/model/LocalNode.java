package de.jutzig.platform.model;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

public class LocalNode implements Node {

	private Map<String, String> properties;
	private Collection<String> roles;
	
	
	
	@SuppressWarnings("null")
	public LocalNode(Map<String, String> properties, Collection<String> roles) throws IOException {
		super();
		this.properties = properties;
		this.roles = roles;
		ConfigurationAdmin configAdmin=null;
		 Configuration configuration = configAdmin.getConfiguration("de.jutzig.platform.model.nodes");
		 configuration.update();
	}

	@Override
	public String getType() {
		return TYPE_LOCAL;
	}

	@Override
	public Collection<String> getRoles() {
		return roles;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void provision() {
		// TODO Auto-generated method stub

	}

}
