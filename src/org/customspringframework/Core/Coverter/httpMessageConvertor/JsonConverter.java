package org.customspringframework.Core.Coverter.httpMessageConvertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter implements Converter {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convert(Object obj) throws JsonProcessingException {
        String result;
        result = objectMapper.writeValueAsString(obj);
        return result;
    }
}
