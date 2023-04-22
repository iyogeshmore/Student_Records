package com.example.studentrecords.Model;

import com.example.studentrecords.DTO.StudentDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String email;
    private String address;

    public Student(StudentDTO studentDTO) {
        this.name = studentDTO.name;
        this.age = studentDTO.age;
        this.email = studentDTO.email;
        this.address = studentDTO.address;
    }

    public void updateStudentData(StudentDTO studentDTO) {
        this.name = studentDTO.name;
        this.age = studentDTO.age;
        this.email = studentDTO.email;
        this.address = studentDTO.address;
    }
}

