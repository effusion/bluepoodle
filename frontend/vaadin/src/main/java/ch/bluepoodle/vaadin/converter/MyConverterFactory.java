package ch.bluepoodle.vaadin.converter;

import ch.bluepoodle.domain.EventState;
import ch.bluepoodle.domain.EventType;
import ch.bluepoodle.domain.Location;
import ch.bluepoodle.domain.Publisher;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.DefaultConverterFactory;

public class MyConverterFactory extends DefaultConverterFactory {
  
	private static final long serialVersionUID = 4753567968832803172L;

	@Override
    protected <PRESENTATION, MODEL> Converter<PRESENTATION, MODEL> findConverter(
            Class<PRESENTATION> presentationType, Class<MODEL> modelType) {
        // Handle String <-> Double
        if (presentationType == String.class && modelType == EventType.class) {
            return (Converter<PRESENTATION, MODEL>) new EventTypeConverter();
        }
        if (presentationType == String.class && modelType == Location.class) {
            return (Converter<PRESENTATION, MODEL>) new LocationConverter();
        }
        if (presentationType == String.class && modelType == Publisher.class) {
            return (Converter<PRESENTATION, MODEL>) new PublisherConverter();
        }
        
        if (presentationType == String.class && modelType == EventState.class) {
            return (Converter<PRESENTATION, MODEL>) new EventStateConverter();
        }
        // Let default factory handle the rest
        return super.findConverter(presentationType, modelType);
    }
}