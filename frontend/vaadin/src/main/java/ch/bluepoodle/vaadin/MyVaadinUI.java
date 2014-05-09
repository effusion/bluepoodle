package ch.bluepoodle.vaadin;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.bluepoodle.server.service.PublisherService;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
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
	private PublisherService publisherService;
	
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        List<ch.bluepoodle.domain.Event> events = publisherService.findAllEvents(2L);
        Table table = new Table("My organized events");
        table.addContainerProperty("Eventname", String.class, null);
        for (ch.bluepoodle.domain.Event event : events) {
			table.addItem(new Object[]{event.getName()},event.getId());
		}
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
        layout.addComponent(table);
    }

}
