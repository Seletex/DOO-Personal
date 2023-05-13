package co.edu.uco.publiuco.api.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;

public final class Result {

	private List<String> messages;

	private Result(final List<String> messages) {
		setMessages(messages);

	}

	public static final Result create() {
		return new Result(new ArrayList<>());
	}

	public static final Result create(final List<String> messages) {
		return new Result(messages);
	}

	public void addMessage(final String message) {
		if (UtilText.getUtilText().isEmpty(message)) {
			messages.add(UtilText.getUtilText().applyTrim(message));
		}
	}

	private void setMessages(final List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList<>());
	}

	public boolean isValid() {
		return messages.isEmpty();
	}

	public List<String> getMessages() {
		return messages;
	}

	public void addMessages(final List<String> messages) {
		getMessages().addAll(UtilObject.getDefault(messages, new ArrayList<>()));
	}

}
