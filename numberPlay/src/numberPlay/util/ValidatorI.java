package numberPlay.util;
/**
 * Validator interface used for validation
 */
public interface ValidatorI {
    void run() throws Exception;
}

final class ValidatorUtil {
	public static void validate(String baseErrMsg, ValidatorI... validators) throws Exception {
		for (ValidatorI validator : validators) {
			try {
				validator.run();
			} catch (Exception e) {
				throw new Exception(baseErrMsg.concat(": " + e.getMessage()), e);
			}
		}

	}
}