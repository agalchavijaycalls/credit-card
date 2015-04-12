package btbw.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CreditCardExpiryValidator implements ConstraintValidator<CreditCardExpiry, String> {

	@Override
	public void initialize(CreditCardExpiry constraintAnnotation) {

	}

	@Override
	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		return object.matches("(?:0[1-9]|1[0-2])/[0-9]{4}");
	}
}