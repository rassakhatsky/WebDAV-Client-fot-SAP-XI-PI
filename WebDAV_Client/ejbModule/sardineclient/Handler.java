package sardineclient;

import com.test.webdav.DTWebDAVResp;
import com.test.webdav.DTWebDAV.WebDAV;

public class Handler {

    public byte[] executePut(WebDAV message) {
        DTWebDAVResp.WebDAV response;
        Execution exec;
        response = new DTWebDAVResp.WebDAV();
        response.setServerAddress(message.getServerAddress());
        response.setUser(message.getUser());
        response.setAction(message.getAction());

        if ((!message.getMessage().getRow().isEmpty()) || (!(message.getMessage().getRow() == null))) {
            for (int i = 0; i < message.getMessage().getRow().size(); i++) {
                response.setMessage(message.getMessage());
            }
        }
        exec = new Execution();
        exec.createFile(response);
        return exec.getOutput();
    }
}
