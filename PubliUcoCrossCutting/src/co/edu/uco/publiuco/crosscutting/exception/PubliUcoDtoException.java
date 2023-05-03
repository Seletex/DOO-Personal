package co.edu.uco.publiuco.crosscutting.exception;

public class PubliUcoDtoException extends PubliUcoException {

	private static final long serialVersionUID = 2324985716431320544L;

	private PubliUcoDtoException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.ENTITY);
		
	}

	public static PubliUcoDtoException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new PubliUcoDtoException(technicalMessage, userMessage, rootMessage);
	}

	public static PubliUcoDtoException create(final String userMessage) {
		return new PubliUcoDtoException(userMessage, userMessage, new Exception());
	}

	public static PubliUcoDtoException create(final String technicalMessage, final String userMessage) {
		return new PubliUcoDtoException(technicalMessage, userMessage, new Exception());
	}

}
