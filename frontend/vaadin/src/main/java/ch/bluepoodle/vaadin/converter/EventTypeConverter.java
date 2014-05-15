package ch.bluepoodle.vaadin.converter;

import java.util.Locale;

import ch.bluepoodle.domain.EventType;

import com.vaadin.data.util.converter.Converter;

public class EventTypeConverter implements Converter<String, EventType> {

	@Override
	public EventType convertToModel(String value,
			Class<? extends EventType> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		// TODO Auto-generated method stub
		EventType eventTyp = new EventType();
		eventTyp.setName(value);
		return eventTyp;
	}

	@Override
	public String convertToPresentation(EventType value,
			Class<? extends String> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return value.getName();
	}

	@Override
	public Class<EventType> getModelType() {
		return EventType.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}

}
