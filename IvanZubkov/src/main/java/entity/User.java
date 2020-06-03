package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String login;
    private String name;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
