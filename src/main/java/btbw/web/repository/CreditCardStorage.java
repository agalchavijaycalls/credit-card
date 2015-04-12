package btbw.web.repository;

import java.util.List;

public interface CreditCardStorage {

	void add(Card newCard);

	void update(Card newCard);

	boolean isExit(String number);

	List<Card> getAll();

	List<Card> getAllBy(String number);

	Card get(String number);
}
