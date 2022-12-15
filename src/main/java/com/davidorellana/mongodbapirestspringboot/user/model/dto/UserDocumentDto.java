package com.davidorellana.mongodbapirestspringboot.user.model.dto;

import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serial;
import java.io.Serializable;

public class UserDocumentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String lastName;
    @Indexed(unique = true)
    private String email;

    public UserDocumentDto() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
