package org.liftoff.BookApp.models;

import javax.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull
    @Email
    private String communication;





    public User() {}

    public User(String username, String password,String communication) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.communication = communication;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getCommunication(){
        return communication;
    }


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
