package co.edu.uco.publiuco.crosscutting.utils;

import java.util.UUID;

public final class UtilUUID {

	public static final String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
	public static final UUID DEFAULT_UUID = generateUUIDFromString(DEFAULT_UUID_AS_STRING);
	private static final String UUID_RE = "[a-f0-9]{8}([-][a-f0-9]{4}){3}[-][a-f0-9]{12}";

	private UtilUUID() {
		super();
	}

	public static final UUID genereteNewUUID() {
		return UUID.randomUUID();
	}

	public static final boolean uuidStringIsValid(final String uuidValue) {
		return UtilText.getUtilText().matchPattern(uuidValue, UUID_RE);
	}

	public static final UUID generateUUIDFromString(final String uuidValue) {

		return uuidStringIsValid(uuidValue) ? UUID.fromString(uuidValue) : DEFAULT_UUID;

	}
	
	public static final UUID getDefault(final UUID uuidValue) {
		return UtilObject.isNull(uuidValue) ? DEFAULT_UUID : uuidValue;
	}
	
	public static final boolean isDefaut(final UUID uuidValue) {
		return DEFAULT_UUID.equals(getDefault(uuidValue));
	}

}
