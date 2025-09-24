package org.customspringframework.Core.Coverter.typeconversion;

import java.util.HashMap;
import java.util.Map;

public class ConversionService {
    private static final Map<Class<?>, Convert<?>> converters = new HashMap<>();

    static {
        register(int.class, Integer::parseInt);
        register(Integer.class, Integer::parseInt);
        register(long.class, Long::parseLong);
        register(Long.class, Long::parseLong);
        register(String.class, s -> s);
        // You can add more types like UUID, Date, etc.
    }

    public static <T> void register(Class<?> type, Convert<T> converter) {
        converters.put(type, converter);
    }


    @SuppressWarnings("unchecked")
    public static <T> T convert(Class<T> targetType, String value) {
        Convert<T> converter = (Convert<T>) converters.get(targetType);
        if (converter == null) {
            throw new IllegalArgumentException("No converter for type: " + targetType.getName());
        }
        return converter.convert(value);
    }
}

