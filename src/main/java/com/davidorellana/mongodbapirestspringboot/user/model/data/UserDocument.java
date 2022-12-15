package com.davidorellana.mongodbapirestspringboot.user.model.data;

import com.davidorellana.mongodbapirestspringboot.user.model.dto.UserDocumentDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "user_document")
public class UserDocument implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC-5h")
    private Date createdOnDate;

    public UserDocument() { }

    public UserDocument(UserDocumentDto userDocumentDto) {
        this.name = userDocumentDto.getName();
        this.lastName = userDocumentDto.getLastName();
        this.email = userDocumentDto.getEmail();
        this.createdOnDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getCreatedOnDate() {
        return createdOnDate;
    }

    public void setCreatedOnDate(Date createdOnDate) {
        this.createdOnDate = createdOnDate;
    }

    public void updateUserDocument(UserDocumentDto userDocumentDto) {
        this.name = userDocumentDto.getName();
        this.lastName = userDocumentDto.getLastName();
        this.email = userDocumentDto.getEmail();
    }
}
