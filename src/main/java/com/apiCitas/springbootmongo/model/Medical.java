package com.apiCitas.springbootmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "medicals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medical {

    @Id
    private String medicalId;
    private String doctorId;
    private String pacientId;
    private String specialty;
    private Date date;
}
