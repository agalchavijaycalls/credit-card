package btbw.web.service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidatorService<T> {

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();

	public boolean isValidate(T obj) {
		return getValidatorErrors(obj).size() > 0 ? false : true;
	}

	public Map<String, String> getValidatorErrors(T obj) {

		Set<ConstraintViolation<T>> validatorError = validator.validate(obj);

		Map<String, String> errors = new HashMap<String, String>();

		for (ConstraintViolation<T> item : validatorError) {
			errors.put(item.getPropertyPath().toString(), item.getMessage());
		}

		return errors;
	}
}