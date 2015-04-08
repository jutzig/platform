package de.jutzig.platform.model;

import java.util.Collection;

public interface Node {

	String TYPE_LOCAL = "local";
	String TYPE_SSH = "ssh";
	
	public String getType();
	
	public Collection<String> getRoles();

	public void stop();
	
	public void start();
	
	public void provision();
}
