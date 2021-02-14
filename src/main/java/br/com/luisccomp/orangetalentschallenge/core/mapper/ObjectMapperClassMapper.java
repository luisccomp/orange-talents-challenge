package br.com.luisccomp.orangetalentschallenge.core.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperClassMapper implements ClassMapper {

    private final ObjectMapper objectMapper;

    @Autowired
    public ObjectMapperClassMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T, U> U map(T object, Class<U> target) {
        return objectMapper.convertValue(object, target);
    }

}
