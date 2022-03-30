package ru.kosmos.restaurantratingsystem.dto;

import ru.kosmos.restaurantratingsystem.util.validation.NoHtml;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

public class UsersDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 2, max = 100)
    @NoHtml
    private String name;

    @Email
    @NotBlank
    @Size(max = 100)
    @NoHtml // https://stackoverflow.com/questions/17480809
    private String email;

    @NotBlank
    @Size(min = 5, max = 32)
    private String password;

    public UsersDTO() {
    }

    public UsersDTO(Integer id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
