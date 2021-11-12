package com.bulletin_board.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static com.bulletin_board.util.ConstantsUtil.VALIDATOR_FACTORY;

public class ValidatorUtil {

    public static <T> boolean validate(T t) {
        Validator validator = VALIDATOR_FACTORY.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        return violations.isEmpty();
    }
}
