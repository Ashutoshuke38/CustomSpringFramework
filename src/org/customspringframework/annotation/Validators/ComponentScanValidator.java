package org.customspringframework.annotation.Validators;

import org.customspringframework.annotation.ComponentScan;

class ComponentScanValidator implements IValidator{

    @Override
    public void validate(Class<?> clazz) {
        if(!clazz.isAnnotationPresent(ComponentScan.class))
            throw new RuntimeException("Missing @ComponentScan on " + clazz.getName());
    }
    
}
