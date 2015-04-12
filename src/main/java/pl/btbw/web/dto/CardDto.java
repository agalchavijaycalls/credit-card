package pl.btbw.web.dto;

import pl.btbw.core.validator.CreditCardExpiry;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotEmpty;

public class CardDto {

	@NotEmpty(message = "Credit Card Number cannot be empty")
	@CreditCardNumber(message = "Credit Card Number has wrong format")
	private String number;

	@NotEmpty(message = "Credit Card Name cannot be empty")
	private String name;

	@CreditCardExpiry(message = "Expiry is invalid")
	private String expiration;

	public CardDto() {
	}

	public CardDto(String number, String name, String expiration) {
		this.number = number;
		this.name = name;
		this.expiration = expiration;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	@Override
	public String toString() {
		return "CardDto{" +
				"number='" + number + '\'' +
				", name='" + name + '\'' +
				", expiration='" + expiration + '\'' +
				'}';
	}
}
