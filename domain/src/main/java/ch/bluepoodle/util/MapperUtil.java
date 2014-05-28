package ch.bluepoodle.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

public class MapperUtil {
	public static <SRC, DEST> List<DEST> map(final Mapper mapper, final List<SRC> source, final Class<DEST> destType) {
		final List<DEST> dest = new ArrayList<>();
		for (SRC element : source) {
	        dest.add(mapper.map(element, destType));
	    }
	    return dest;
	}
}
