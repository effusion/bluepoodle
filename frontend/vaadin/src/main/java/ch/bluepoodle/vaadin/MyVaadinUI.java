package ch.bluepoodle.vaadin;

import ch.bluepoodle.datatransfer.EventDTO;
import ch.bluepoodle.datatransfer.EventMapping;
import ch.bluepoodle.server.service.PublisherService;
import ch.bluepoodle.util.MapperUtil;
import ch.bluepoodle.vaadin.converter.MyConverterFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Theme("mytheme")
public class MyVaadinUI extends UI{
	
	private static final long serialVersionUID = -6169543319998150557L;

	@Autowired
	private transient ApplicationContext applicationContext;
	
	@Autowired
	private transient PublisherService publisherService;

    private DozerBeanMapper mapper = new DozerBeanMapper();
	
    @Override
    protected void init(VaadinRequest request) {
        mapper.addMapping(new EventMapping());
    	VaadinSession.getCurrent().setConverterFactory(new MyConverterFactory());
    	final VerticalLayout parent = new VerticalLayout();
        final VerticalLayout navigation = new VerticalLayout();
    	final VerticalLayout selection = new VerticalLayout();
        final VerticalLayout detail = new VerticalLayout();

        Label event = new Label("Event");
        event.setStyleName("v-label-poodle-header");
        navigation.addComponent(event);
    	
    	Label text = new Label("Bluepoodle");
    	text.setStyleName("v-label-poodle-header");
    	parent.addComponent(text);
    	
      
        List<ch.bluepoodle.domain.Event> events = publisherService.findAllEvents(2L);
        List<EventDTO> mappedEvents = MapperUtil.map(mapper, events, EventDTO.class);
        Table table = new Table();
        table.setSelectable(true);
        table.setNullSelectionAllowed(true);
        BeanItemContainer<EventDTO> beans = new BeanItemContainer<>(EventDTO.class);
        beans.addAll(mappedEvents);
        table.setContainerDataSource(beans);
        table.setEditable(true);
        selection.addComponent(table);
        parent.addComponent(navigation);
        parent.addComponent(selection);
        parent.setComponentAlignment(selection, Alignment.MIDDLE_CENTER);
        setContent(parent);
    }

}
