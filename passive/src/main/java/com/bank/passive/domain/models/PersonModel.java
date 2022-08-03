package com.bank.passive.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonModel {
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
