package co.edu.uco.publiuco.crosscutting.exception;

public class PubliUcoCrossCuttingException extends PubliUcoException {

	private static final long serialVersionUID = 2324985716431320544L;

	private PubliUcoCrossCuttingException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.CROSSCUTTING);
		
	}

	public static PubliUcoCrossCuttingException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new PubliUcoCrossCuttingException(technicalMessage, userMessage, rootMessage);
	}

	public static PubliUcoCrossCuttingException create(final String userMessage) {
		return new PubliUcoCrossCuttingException(userMessage, userMessage, new Exception());
	}

	public static PubliUcoCrossCuttingException create(final String technicalMessage, final String userMessage) {
		return new PubliUcoCrossCuttingException(technicalMessage, userMessage, new Exception());
	}

	public static Exception createTechnicalException(String technicalTryInitTransaction) {
		// TODO Auto-generated method stub
		return null;
	}

}
