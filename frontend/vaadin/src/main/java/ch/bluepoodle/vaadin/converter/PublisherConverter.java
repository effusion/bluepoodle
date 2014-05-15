package ch.bluepoodle.vaadin.converter;

import java.util.Locale;

import ch.bluepoodle.domain.Publisher;

import com.vaadin.data.util.converter.Converter;

public class PublisherConverter implements Converter<String, Publisher> {
	private static final long serialVersionUID = -8286662869173759992L;

	@Override
	public Publisher convertToModel(String value,
			Class<? extends Publisher> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		// TODO Auto-generated method stub
		Publisher location = new Publisher();
		location.setId(Long.valueOf(value));
		return location;
	}

	@Override
	public String convertToPresentation(Publisher value,
			Class<? extends String> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return String.valueOf(value.getId());
	}

	@Override
	public Class<Publisher> getModelType() {
		return Publisher.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}

}
