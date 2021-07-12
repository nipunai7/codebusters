package intergrative.mit.codebusters.Models;

public class Login{
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Login(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }

    public String email;
    public String passWord;
}
