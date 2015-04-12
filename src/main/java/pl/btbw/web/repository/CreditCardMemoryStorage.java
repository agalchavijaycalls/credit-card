package pl.btbw.web.repository;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CreditCardMemoryStorage implements CreditCardStorage {

	private List<Card> storage = new ArrayList<>();

	@Override
	public void add(Card newCard) {
		storage.add(newCard);
	}

	@Override
	public void update(Card newCard) {
		Card card = get(newCard.getNumber());
		if (card != null) {
			card.setExpiration(newCard.getExpiration());
		}
	}

	@Override
	public boolean isExit(String number) {
		for (Card card : storage) {
			if (card.getNumber().equals(number)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Card> getAll() {
		return storage;
	}

	@Override
	public List<Card> getAllBy(String number) {
		List<Card> data = new ArrayList<>();
		for (Card card : storage) {
			if (card.getNumber().contains(number)) {
				data.add(card);
			}
		}
		return data;
	}

	@Override
	public Card get(String number) {
		for (Card card : storage) {
			if (card.getNumber().equals(number)) {
				return card;
			}
		}
		return null;
	}
}
