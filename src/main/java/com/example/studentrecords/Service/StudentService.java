package com.example.studentrecords.Service;

import com.example.studentrecords.DTO.StudentDTO;
import com.example.studentrecords.Exeception.StudentException;
import com.example.studentrecords.Model.Student;
import com.example.studentrecords.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IstudentService {
    @Autowired
    StudentRepo studentRepo;

    //--------------------------------- Add Student ---------------------------------
    @Override
    public Student addStudent(StudentDTO studentDTO) {
        Student newStudent = new Student(studentDTO);
        return studentRepo.save(newStudent);
    }

    //--------------------------------- Get All Student Record ---------------------------------
    @Override
    public List<Student> getAllStudentRecord() {
        return studentRepo.findAll();
    }

    //--------------------------------- Get Student By Id ---------------------------------
    @Override
    public Student getStudentById(int id) {
        if (studentRepo.findById(id).isPresent()) {
            return studentRepo.findById(id).get();
        }
        throw new StudentException("Student not found from id " + id + "\n Invalid Id");
    }

    //--------------------------------- Update Student Record ---------------------------------
    @Override
    public Student updateStudent(int id, StudentDTO studentDTO) {
        Student studentData = this.getStudentById(id);
        studentData.updateStudentData(studentDTO);
        return studentRepo.save(studentData);
    }

    //--------------------------------- Delete Student Record ---------------------------------
    @Override
    public String deleteStudentRecord(int id) {
        if (studentRepo.findById(id).isPresent()) {
            studentRepo.deleteById(id);
            return "Data Deleted successful";
        }
        throw new StudentException("Student Not Found From Id " + id + "\nInvalid Id ");
    }
}
