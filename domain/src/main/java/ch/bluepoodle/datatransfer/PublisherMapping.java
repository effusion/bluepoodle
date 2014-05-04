package ch.bluepoodle.datatransfer;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import ch.bluepoodle.domain.Publisher;

public class PublisherMapping extends BeanMappingBuilder {

	@Override
	protected void configure() {
		mapping(Publisher.class, PublisherDTO.class, TypeMappingOptions.oneWay());
	}

}
