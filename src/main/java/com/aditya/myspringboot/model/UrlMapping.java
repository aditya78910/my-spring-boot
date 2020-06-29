package com.aditya.myspringboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "UrlMapping")
@Data
public class UrlMapping implements Serializable {

    @Id
    private String newUrl;
    private String oldUrl;
    private String email;

    public UrlMapping()
    {

    }

    public UrlMapping(String sNewUrl, String sOldUrl, String email)
    {
        this.newUrl = sNewUrl;
        this.oldUrl = sOldUrl;
        this.email = email;
    }

    public String getNewUrl() {
        return newUrl;
    }
    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }
    public String getOldUrl() {
        return oldUrl;
    }
    public void setOldUrl(String oldUrl) {
        this.oldUrl = oldUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}