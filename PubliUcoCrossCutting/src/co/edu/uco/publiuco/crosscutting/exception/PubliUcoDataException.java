package co.edu.uco.publiuco.crosscutting.exception;

public class PubliUcoDataException extends PubliUcoException {

	private static final long serialVersionUID = 2324985716431320544L;

	private PubliUcoDataException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.DATA);
		
	}

	public static PubliUcoDataException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new PubliUcoDataException(technicalMessage, userMessage, rootMessage);
	}

	public static PubliUcoDataException create(final String userMessage) {
		return new PubliUcoDataException(userMessage, userMessage, new Exception());
	}

	public static PubliUcoDataException create(final String technicalMessage, final String userMessage) {
		return new PubliUcoDataException(technicalMessage, userMessage, new Exception());
	}

}
