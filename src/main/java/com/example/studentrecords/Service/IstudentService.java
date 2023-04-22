package com.example.studentrecords.Service;

import com.example.studentrecords.DTO.StudentDTO;
import com.example.studentrecords.Model.Student;

import java.util.List;

public interface IstudentService {
    Student addStudent(StudentDTO studentDTO);

    List<Student> getAllStudentRecord();

    Student getStudentById(int id);

    Student updateStudent(int id, StudentDTO studentDTO);

    String deleteStudentRecord(int id);
}
