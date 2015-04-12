package btbw.web.dto;


import btbw.web.service.ValidatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CardDtoValidationTest {

	@InjectMocks
	private ValidatorService<CardDto> validatorService;

	@Test
	public void shouldCardNumberBeInValid() {

		// arrange & act
		Map<String, String> validatorErrors = validatorService.getValidatorErrors(
				new CardDto("111282246310005", "Mr. American Express", "01/2012")
		);

		// assert
		assertThat(validatorErrors.get("number")).isEqualTo("Credit Card Number has wrong format");
	}

	@Test
	public void shouldCardNameBeInValid1() {

		// arrange & act
		Map<String, String> validatorErrors1 = validatorService.getValidatorErrors(
				new CardDto("378282246310005", null, "01/2012")
		);

		// assert
		assertThat(validatorErrors1.get("name")).isEqualTo("Credit Card Name cannot be empty");
	}

	@Test
	public void shouldCardNameBeInValid() {

		// arrange & act
		Map<String, String> validatorErrors2 = validatorService.getValidatorErrors(
				new CardDto("378282246310005", "", "01/2012")
		);

		// assert
		assertThat(validatorErrors2.get("name")).isEqualTo("Credit Card Name cannot be empty");
	}

	@Test
	public void shouldCardExpiryBeInValid_1() {

		// arrange & act
		Map<String, String> validatorErrors1 = validatorService.getValidatorErrors(
				new CardDto("378734493671000", "Mr. American Express", "")
		);

		// assert
		assertThat(validatorErrors1.get("expiration")).isEqualTo("Expiry is invalid");
	}

	@Test
	public void shouldCardExpiryBeInValid_2() {

		// arrange & act
		Map<String, String> validatorErrors2 = validatorService.getValidatorErrors(
				new CardDto("378734493671000", "Mr. American Express", "2011")
		);

		// assert
		assertThat(validatorErrors2.get("expiration")).isEqualTo("Expiry is invalid");
	}

	@Test
	public void shouldBeValid() {
		// arrange & act & assert
		assertThat(
				validatorService.isValidate(
						new CardDto("378282246310005", "Mr. American Express", "01/2012")
				)
		).isTrue();

		assertThat(
				validatorService.isValidate(
						new CardDto("378734493671000", "Mr. American Express Corporate", "02/2012")
				)
		).isTrue();

		assertThat(
				validatorService.isValidate(
						new CardDto("5610591081018250", "Mr. Australian BankCard", "03/2012")
				)
		).isTrue();

		assertThat(
				validatorService.isValidate(
						new CardDto("30569309025904", "Mr. Diners Club", "04/2012")
				)
		).isTrue();

		assertThat(
				validatorService.isValidate(
						new CardDto("5555555555554444", "Mr. MasterCard", "05/2012")
				)
		).isTrue();

		assertThat(
				validatorService.isValidate(
						new CardDto("4111111111111111", "Mr. Visa", "01/2012")
				)
		).isTrue();
	}
}