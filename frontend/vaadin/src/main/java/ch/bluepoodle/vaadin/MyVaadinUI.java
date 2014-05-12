package ch.bluepoodle.vaadin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.bluepoodle.server.service.PublisherService;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
public class MyVaadinUI extends UI{
	
	private static final long serialVersionUID = -6169543319998150557L;

	@Autowired
	private transient ApplicationContext applicationContext;
	
	@Autowired
	private transient PublisherService publisherService;
	
    @Override
    protected void init(VaadinRequest request) {
    	final HorizontalLayout header = new HorizontalLayout();
    	final VerticalLayout parent = new VerticalLayout();
    	final VerticalLayout body = new VerticalLayout();
    	final VerticalLayout navigations = new VerticalLayout();
    	
    	Button viewEvents = new Button();
    	Button createEvent = new Button();
    	Button viewEventTyps = new Button();
    	
    	navigations.addComponent(viewEvents);
    	navigations.addComponent(createEvent);
    	navigations.addComponent(viewEventTyps);
    	
    	header.setSizeFull();
    	Label text = new Label("Bluepoode");
    	header.setMargin(true);
    	setContent(header);
    	header.addComponent(text);
       
    	body.setMargin(true);
    	
        setContent(parent);
        List<ch.bluepoodle.domain.Event> events = publisherService.findAllEvents(2L);
        Table table = new Table("My organized events");
        table.setSelectable(true);
        table.setNullSelectionAllowed(true);
        table.addContainerProperty("Eventname", String.class, null);
        table.addContainerProperty("Location", String.class, null);
        for (ch.bluepoodle.domain.Event event : events) {
			table.addItem(new Object[]{event.getName(),event.getLocation().getName()},event.getId());
		}
        
        
        body.addComponent(table);
        parent.addComponent(header);
        parent.addComponent(navigations);
        parent.setComponentAlignment(navigations, Alignment.MIDDLE_CENTER);
    	parent.addComponent(body);
    	parent.setComponentAlignment(body, Alignment.MIDDLE_CENTER);
    }

}
