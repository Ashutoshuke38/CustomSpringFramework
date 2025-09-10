package org.customspringframework.annotation.Validators;

import java.util.List;

public abstract class AnnotationValidator {
    private final List<IValidator> validators;

    public AnnotationValidator(List<IValidator> lValidator)
    {
        validators = lValidator;
    }

    public void validate(Class<?> clazz)
    {
        for(IValidator validator : validators)
        {
            validator.validate(clazz);
        }
    }
}
