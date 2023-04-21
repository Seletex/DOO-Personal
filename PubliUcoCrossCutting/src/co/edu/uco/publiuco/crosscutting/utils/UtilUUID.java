package co.edu.uco.publiuco.crosscutting.utils;

import java.util.UUID;

public final class UtilUUID {

	public static final String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
	public static final UUID DEFAULT_UUID = generateUUIDFromString(DEFAULT_UUID_AS_STRING);

	private UtilUUID() {
		super();
	}

	public static final UUID genereteNewUUID() {
		return UUID.randomUUID();
	}

	public static final UUID generateUUIDFromString(final String uuidValue) {
		return UUID.fromString(uuidValue);
	}

}
