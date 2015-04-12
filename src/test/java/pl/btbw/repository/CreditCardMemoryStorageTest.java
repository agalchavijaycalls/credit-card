package pl.btbw.repository;

import pl.btbw.web.repository.Card;
import pl.btbw.web.repository.CreditCardMemoryStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardMemoryStorageTest {

	@InjectMocks
	private CreditCardMemoryStorage storage;

	@Test
	public void shouldBePossibleSaveItem() {

		// arrange
		storage.add(
				new Card("0000111100001111", "Michał Szałkowski", "11/16")
		);

		// act
		Card card = storage.get("0000111100001111");

		// assert
		assertThat(card.getNumber()).isEqualTo("0000111100001111");
		assertThat(card.getName()).isEqualTo("Michał Szałkowski");
		assertThat(card.getExpiration()).isEqualTo("11/16");

	}

	@Test
	public void shouldBePossibleUpdateItem() {
		// arrange & act
		storage.add(
				new Card("0000111100001111", "Michał Szałkowski", "01/01")
		);
		storage.update(
				new Card("0000111100001111", "Michał Szałkowski", "02/02")
		);

		// assert
		assertThat(storage.get("0000111100001111").getExpiration()).isEqualTo("02/02");
	}

	@Test
	public void shouldBePossibleToCheckIfItemExist() {

		// arrange
		storage.add(
				new Card("1111222233334444", "Michał Szałkowski", "11/16")
		);

		// act & assert
		assertThat(storage.isExit("1111222233334444")).isTrue();
	}

	@Test
	public void shouldBePossibleToFetchAllItems() {

		// arrange
		storage.add(
				new Card("0000111100001111", "Michał Szałkowski", "11/16")
		);

		storage.add(
				new Card("0000111100001112", "Michał Szałkowski", "11/16")
		);

		// act
		List<Card> all = storage.getAll();

		// assert
		assertThat(all).hasSize(2);
	}
}