package pl.btbw.web.controller;

import pl.btbw.web.dto.CardDto;
import pl.btbw.web.dto.Response;
import pl.btbw.web.dto.ResponseStatus;
import pl.btbw.web.repository.Card;
import pl.btbw.web.repository.CreditCardStorage;
import pl.btbw.web.service.ValidatorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/")
public class CreditCardController {

	@Inject
	private CreditCardStorage memoryStorage;

	@Inject
	private ValidatorService<CardDto> validatorService;

	@POST
	@Path("/card")
	@Produces("application/json")
	public Response addNewCard(CardDto dto) {

		if (validatorService.isValidate(dto)) {

			String number = dto.getNumber();
			String name = dto.getName();
			String expiration = dto.getExpiration();

			if (memoryStorage.isExit(number)) {
				memoryStorage.update(new Card(number, name, expiration));
				return new Response(ResponseStatus.SUCCESS_UPDATE);
			}

			memoryStorage.add(new Card(number, name, expiration));
			return new Response(ResponseStatus.SUCCESS_ADD);
		}

		return new Response(
				ResponseStatus.ERROR,
				validatorService.getValidatorErrors(dto)
		);
	}

	@GET
	@Path("/card")
	@Produces("application/json")
	public List<Card> all() {
		return memoryStorage.getAll();
	}

	@GET
	@Path("/card/{number}")
	@Produces("application/json")
	public List<Card> filter(@PathParam("number") String number) {
		return memoryStorage.getAllBy(number);
	}

}
