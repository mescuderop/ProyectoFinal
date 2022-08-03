package com.bank.initial.infraestructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class Person {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String numberDocument;
    private String typeDocument;
    private String typePerson;
    private String address;
    private String email;
    private String phone;
}
