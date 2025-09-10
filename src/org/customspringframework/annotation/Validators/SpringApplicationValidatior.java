package org.customspringframework.annotation.Validators;

import org.customspringframework.annotation.SpringBootApplication;

class SpringApplicationValidatior implements IValidator {

    @Override
    public void validate(Class<?> clazz) {
        if(!clazz.isAnnotationPresent(SpringBootApplication.class))
            throw new RuntimeException("Missing @SpringApplication on " + clazz.getName());
    }
    
}

