package org.customspringframework.annotation.Validators;

import java.util.Arrays;

public class StartUpValidator extends AnnotationValidator {

    public StartUpValidator()
    {
        super(Arrays.asList(
            new SpringApplicationValidatior(),
            new ComponentScanValidator()
        ));
    }
}