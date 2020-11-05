package tr.com.obss.bookportalserverside.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {
    @NotBlank
    @Size(max = 255, min = 3, message = "Please enter a valid UserName!")
    private String username;

    @NotBlank
    @Size(max = 255, min = 3, message = "Please enter a valid Password!")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
