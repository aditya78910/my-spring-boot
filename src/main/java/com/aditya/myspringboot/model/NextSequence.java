package com.aditya.myspringboot.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NextSequence")
@Data
public class NextSequence {

    @Id
    private String _id;

    private Integer sequence;
}
