package pl.btbw.web.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement
public class Response {

	@XmlElement
	private ResponseStatus status;

	@XmlElement
	private Map<String, String> validatorErrors;

	public Response() {
	}

	public Response(ResponseStatus status) {
		this.status = status;
	}

	public Response(ResponseStatus status, Map<String, String> validatorErrors) {
		this.status = status;
		this.validatorErrors = validatorErrors;
	}
}
