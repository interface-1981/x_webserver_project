package action;

import java.io.OutputStream;
import java.util.Map;

public interface Action {

	public void execute(Map<String, String> requestParameter, OutputStream response) throws Exception;
}
