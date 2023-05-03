package co.edu.uco.publiuco.crosscutting.exception;

public class PubliUcoBusinessException extends PubliUcoException {

	private static final long serialVersionUID = 2324985716431320544L;

	private PubliUcoBusinessException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.BUSINESS);
		
	}

	public static PubliUcoBusinessException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new PubliUcoBusinessException(technicalMessage, userMessage, rootMessage);
	}

	public static PubliUcoBusinessException create(final String userMessage) {
		return new PubliUcoBusinessException(userMessage, userMessage, new Exception());
	}

	public static PubliUcoBusinessException create(final String technicalMessage, final String userMessage) {
		return new PubliUcoBusinessException(technicalMessage, userMessage, new Exception());
	}

}
