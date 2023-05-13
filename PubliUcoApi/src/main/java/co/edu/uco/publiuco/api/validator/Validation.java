package co.edu.uco.publiuco.api.validator;

public interface Validation<T> {

	Result execute(T data);
}
