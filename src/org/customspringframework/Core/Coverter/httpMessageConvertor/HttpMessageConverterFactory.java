package org.customspringframework.Core.Coverter.httpMessageConvertor;

import org.customspringframework.Routing.handler.*;
import org.customspringframework.http.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpMessageConverterFactory {

    private final Map<String, Converter> converters = Map.ofEntries(
            Map.entry(MediaType.APPLICATION_JSON, new JsonConverter())
    );


    public Map<String, Converter>  getConverters() {
        return converters;
    }
}
