package intergrative.mit.codebusters.Models;

import javax.validation.constraints.NotNull;


public class Message {

    @NotNull
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
