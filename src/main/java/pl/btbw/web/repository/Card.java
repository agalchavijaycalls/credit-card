package pl.btbw.web.repository;

public class Card {

	private String number;
	private String name;
	private String expiration;

	public Card(String number, String name, String expiration) {
		this.number = number;
		this.name = name;
		this.expiration = expiration;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
}
