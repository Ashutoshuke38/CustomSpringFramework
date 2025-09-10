package org.customspringframework.annotation.Validators;

class ControllerValidator implements IValidator{

    @Override
    public void validate(Class<?> clazz) {
        throw new RuntimeException("Missing @ControllerValidator on " + clazz.getName());
    }
    
}
