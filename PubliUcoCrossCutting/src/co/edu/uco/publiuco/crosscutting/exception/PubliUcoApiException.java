package co.edu.uco.publiuco.crosscutting.exception;

public class PubliUcoApiException extends PubliUcoException {

	private static final long serialVersionUID = 2324985716431320544L;

	private PubliUcoApiException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.API);
		
	}

	public static PubliUcoApiException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new PubliUcoApiException(technicalMessage, userMessage, rootMessage);
	}

	public static PubliUcoApiException create(final String userMessage) {
		return new PubliUcoApiException(userMessage, userMessage, new Exception());
	}

	public static PubliUcoApiException create(final String technicalMessage, final String userMessage) {
		return new PubliUcoApiException(technicalMessage, userMessage, new Exception());
	}

}
