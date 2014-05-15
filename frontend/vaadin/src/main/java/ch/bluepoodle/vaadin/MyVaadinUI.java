package ch.bluepoodle.vaadin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.bluepoodle.server.service.PublisherService;
import ch.bluepoodle.vaadin.converter.EventTypeConverter;
import ch.bluepoodle.vaadin.converter.MyConverterFactory;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@Theme("mytheme")
public class MyVaadinUI extends UI{
	
	private static final long serialVersionUID = -6169543319998150557L;

	@Autowired
	private transient ApplicationContext applicationContext;
	
	@Autowired
	private transient PublisherService publisherService;
	
    @Override
    protected void init(VaadinRequest request) {
    	VaadinSession.getCurrent().setConverterFactory(new MyConverterFactory());
    	final VerticalLayout parent = new VerticalLayout();
    	final GridLayout grid = new GridLayout(2, 3);
    	final VerticalLayout navigation = new VerticalLayout();
    	
    	
    	Button viewEvents = new Button("Test");
    	Button createEvent = new Button("Test");
    	Button viewEventTyps = new Button("Test");
    
    	
    	navigation.addComponent(viewEvents);
    	navigation.addComponent(createEvent);
    	navigation.addComponent(viewEventTyps);
    	
    	
    	Label text = new Label("Bluepoodle");
    	text.setStyleName("v-label-poodle-header");
    	grid.addComponent(text, 0, 0, 1, 0);
    	grid.addComponent(navigation,0,1);     
    	
      
        List<ch.bluepoodle.domain.Event> events = publisherService.findAllEvents(2L);
        Table table = new Table();
        table.setSelectable(true);
        table.setNullSelectionAllowed(true);
        table.addContainerProperty("Eventname", String.class, null);
        table.addContainerProperty("Location", String.class, null);
        BeanItemContainer<ch.bluepoodle.domain.Event> beans = new BeanItemContainer<ch.bluepoodle.domain.Event>(ch.bluepoodle.domain.Event.class);
        beans.addAll(events);
        table.setContainerDataSource(beans);
        table.setEditable(true);
        grid.addComponent(table,1,1);
        parent.addComponent(grid);
        parent.setComponentAlignment(grid, Alignment.MIDDLE_CENTER);
        setContent(parent);
    }

}
