package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;



import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;

public class DescripcionValidation implements Validation<String> {

	private DescripcionValidation() {
		super();
	}

	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);

	}

	@Override
	public Result execute(String data) {
		
		return null;
	}
}
