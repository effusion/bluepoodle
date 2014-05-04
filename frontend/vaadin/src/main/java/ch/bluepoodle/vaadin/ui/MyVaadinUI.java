package ch.bluepoodle.vaadin.ui;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch.bluepoodle.server.service.PublisherService;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
public class MyVaadinUI extends UI{
	
	@Autowired
	private PublisherService publisherService;
	
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
//        List<ch.bluepoodle.domain.Event> events = publisherService.findAllEvents(2L);
//        Table table = new Table("Event Table");
//        table.addContainerProperty("Name", String.class , null);
//        for (ch.bluepoodle.domain.Event event : events) {
//			table.addItem(event.getName());
//		}
        
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
        //layout.addComponent(table);
    }

}
