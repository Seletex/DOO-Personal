package co.edu.uco.publiuco.crosscutting.exception;

public class PubliUcoEntityException extends PubliUcoException {

	private static final long serialVersionUID = 2324985716431320544L;

	private PubliUcoEntityException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.DTO);
		
	}

	public static PubliUcoEntityException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new PubliUcoEntityException(technicalMessage, userMessage, rootMessage);
	}

	public static PubliUcoEntityException create(final String userMessage) {
		return new PubliUcoEntityException(userMessage, userMessage, new Exception());
	}

	public static PubliUcoEntityException create(final String technicalMessage, final String userMessage) {
		return new PubliUcoEntityException(technicalMessage, userMessage, new Exception());
	}

}
