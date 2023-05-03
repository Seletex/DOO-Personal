package co.edu.uco.publiuco.crosscutting.utils;

public final class Messages {

	public static final class UtilSqlMessage{
		public static final String CONNECTION_IS_OPEN_USER_MESSAGE_STRING = "Se ha presentado un problema tratando de validar si una conexion con la fuente de informacion estaba activa o no...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING="Se ha ´presentado un problema de tipo SQLException tratando de validar si la conexion estaba o no abierta...\"\r\n"
				+ "					+ \"Valide la traZA DE errores completa de la exception presentada";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION_STRING="Se ha ´presentado un problema de tipo SQLException tratando de validar si la conexion estaba o no abierta...\"\r\n"
				+ "					+ \"Valide la traZA DE errores completa de la exception presentada";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING="Se ha ´presentado un problema de tipo Exception tratando de validar si la conexion estaba o no abierta...\"\r\n"
				+ "					+ \"Valide la traZA DE errores completa de la exception presentada";
	}
	
}
