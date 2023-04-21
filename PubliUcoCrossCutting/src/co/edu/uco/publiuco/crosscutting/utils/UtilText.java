package co.edu.uco.publiuco.crosscutting.utils;

public final class UtilText {

	private static final UtilText INSTANCE = new UtilText();
	public static String EMPTY = "";

	private UtilText() {
		super();

	}

	public static final UtilText getUtilText() {
		return INSTANCE;
	}

	public boolean isNull(final String text) {
		return UtilObject.isNull(text);
	}

	public final String getDefault(final String text, final String defaultValue) {
		String resultString = text;

		if (isNull(text)) {
			resultString = isNull(defaultValue) ? EMPTY : defaultValue;
		}
		return resultString;
	}

	public final String getDefault(final String text) {
		return getDefault(text, EMPTY);
	}
	
	public static final String getDefaultValue() {
		return EMPTY;
	}

	public final String applyTrim(final String text) {
		return getDefault(text).trim();
	}
	
	public final boolean matchPattern(final String textString, final String patterString) {
		return getDefault(textString).matches(getDefault(patterString));
	}

}
