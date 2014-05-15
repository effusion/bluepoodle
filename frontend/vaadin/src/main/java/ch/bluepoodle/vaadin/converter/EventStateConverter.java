package ch.bluepoodle.vaadin.converter;

import java.util.Locale;

import ch.bluepoodle.domain.EventState;

import com.vaadin.data.util.converter.Converter;

public class EventStateConverter implements Converter<String, EventState> {

	private static final long serialVersionUID = -3032736914247315072L;

	@Override
	public EventState convertToModel(String value,
			Class<? extends EventState> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		EventState state = EventState.valueOf(value);
		return state;
	}

	@Override
	public String convertToPresentation(EventState value,
			Class<? extends String> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return value.toString();
	}

	@Override
	public Class<EventState> getModelType() {
		return EventState.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}

}
