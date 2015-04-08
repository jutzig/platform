package de.jutzig.platform;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.communication.URLReference;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
//@Theme("myproject")
public class PlatformUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = false,
            ui = PlatformUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        createMenu(layout);
        
        Button button = new Button("Click Me!!!");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(
                    new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
    }

	private void createMenu(VerticalLayout layout) {
		MenuBar menuBar = new MenuBar();
		menuBar.addItem("OSGi Overview", new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				URLReference reference = new URLReference();
				reference.setURL("/gogo");
				getPage().setLocation("/system/console");
			}
		});
		menuBar.addItem("Resouce Overview", new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {;
				getPage().setLocation("/system/console/res");
			}
		});
		menuBar.addItem("Console", new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				URLReference reference = new URLReference();
				reference.setURL("/gogo");
				getPage().setLocation("/gogo");
			}
		});
		menuBar.addItem("Features", new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {;
				getPage().setLocation("/features");
			}
		});
		layout.addComponent(menuBar);
	}
}