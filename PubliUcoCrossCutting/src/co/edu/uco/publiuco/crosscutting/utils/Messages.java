package co.edu.uco.publiuco.crosscutting.utils;

public final class Messages {

	public static final class UtilSqlMessage{
		
		private UtilSqlMessage()
		{
			
		}
		public static final String CONNECTION_IS_OPEN_USER_MESSAGE_STRING = "Se ha presentado un problema tratando de validar si una conexion con la fuente de informacion estaba activa o no...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING="Se ha ´presentado un problema de tipo SQLException tratando de validar si la conexion estaba o no abierta...\"\r\n"
				+ "					+ \"Valide la traZA DE errores completa de la exception presentada";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION_STRING="Se ha ´presentado un problema de tipo SQLException tratando de validar si la conexion estaba o no abierta...\"\r\n"
				+ "					+ \"Valide la traZA DE errores completa de la exception presentada";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING="Se ha ´presentado un problema de tipo Exception tratando de validar si la conexion estaba o no abierta...\"\r\n"
				+ "					+ \"Valide la traZA DE errores completa de la exception presentada";
		public static final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static final String TECHNICAL_CONNECTION_ALREADY_IS_CLOSED = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "Ha habido un problema tratando de cerrar la conexion. Porfavor verifica los detales tecnicos";
		public static final String USER_PROBLEM_CLOSING_CONNECTION = "Ha habido un problema tratando de cerrar la conexion. Porfavor verifica los detales tecnicos";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is closed to start a new transaction";
		public static final String TECHNICAL_PROBLEM_TO_INIT_TRANSACTION_CONNECTION = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connection is closed to commit the current transaction";
		public static final String TECHNICAL_TRY_COMMIT_TRANSACTION = "There was a problem tryng to commit transaction. Please verify";
		public static final String TECHNICAL_TRY_INIT_TRANSACTION = "There was a problem tryng to current transaction. Please verify the technical error";
		public static final String TECHNICAL_TRY_ROLLBACK_TRANSACTION = "Connection is closed for commit transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection already is closed";
	}
	


		
	
	public static final class EstadoTipoRelacionInstitucionFacadeImplMessage{
public static final String REGISTER_EXCEPTION_USER_MESSAGE_STRING="Se ha presentado un problema tratando de registrar la informion del nuevo estado del tipo de relacion para una institucion. Por favor intente de neuvo y si el problema persiste contacte al administrador de la aplicacion...";
public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING="Se ha presentado una excepcion no conocida al momneto de registrar el nuevo EstadoTipoRelacionInstitucion. porfavor valide la traza completa de la exception presentada";

	}
	
	
}
