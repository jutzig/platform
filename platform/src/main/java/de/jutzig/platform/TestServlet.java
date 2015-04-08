package de.jutzig.platform;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import com.vaadin.server.VaadinServlet;

@Component
@Service(javax.servlet.Servlet.class)
public class TestServlet extends VaadinServlet{
	
	@Property(name="alias",value="/*")
	public String alias = "/*";
	
	@Property(name="init.UI",value="de.jutzig.platform.PlatformUI")
	public String ui = "de.jutzig.platform.MyprojectUI";	
	

}
