package com.bank.initial.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
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
