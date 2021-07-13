package intergrative.mit.codebusters.utils;

public class AuthResponse {

    public AuthResponse() {
    }

    public AuthResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private String response;
}
