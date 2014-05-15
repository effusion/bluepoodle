package ch.bluepoodle.vaadin.converter;

import java.util.Locale;

import ch.bluepoodle.domain.Location;

import com.vaadin.data.util.converter.Converter;

public class LocationConverter implements Converter<String, Location> {
	private static final long serialVersionUID = -8286662869173759992L;

	@Override
	public Location convertToModel(String value,
			Class<? extends Location> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		// TODO Auto-generated method stub
		Location location = new Location();
		location.setName(value);
		return location;
	}

	@Override
	public String convertToPresentation(Location value,
			Class<? extends String> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return value.getName();
	}

	@Override
	public Class<Location> getModelType() {
		return Location.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}

}
