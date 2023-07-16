package com.apiCitas.springbootmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pacients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacient {

    @Id
    private String pacientId;
    private String fullname;
    private Integer document;
    private Integer age;
    private Integer phone;
}
