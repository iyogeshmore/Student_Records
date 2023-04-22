package com.example.studentrecords.Controller;

import com.example.studentrecords.DTO.ResponseDTO;
import com.example.studentrecords.DTO.StudentDTO;
import com.example.studentrecords.Model.Student;
import com.example.studentrecords.Service.IstudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class StudentController {
    @Autowired
    IstudentService istudentService;
    List<Student> studentList = new ArrayList<>();

    //--------------------------------- Add Student ---------------------------------
    @PostMapping("/addStudent")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = istudentService.addStudent(studentDTO);
        ResponseDTO responseDTO = new ResponseDTO("Student added successfully.", student);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get All Student Records ---------------------------------
    @GetMapping("/getAllStudentRecord")
    public ResponseEntity<ResponseDTO> getAllStudentRecord() {
        studentList = istudentService.getAllStudentRecord();
        ResponseDTO responseDTO = new ResponseDTO("We have " + studentList.size() + " Student", studentList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Student By Id ---------------------------------
    @GetMapping("/getStudentById")
    public ResponseEntity<ResponseDTO> getStudentById(@RequestParam("id ") int id) {
        Student studentData = istudentService.getStudentById(id);
        ResponseDTO responseDTO = new ResponseDTO("Student Details of id " + id, studentData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Update Student By Id ---------------------------------
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<ResponseDTO> updateStudent(@PathVariable("id") int id, @RequestBody StudentDTO studentDTO) {
        Student studentData = istudentService.updateStudent(id, studentDTO);
        ResponseDTO responseDTO = new ResponseDTO("Student data updated successfully of Id " + id + "", studentData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete Student By Id ---------------------------------
    @DeleteMapping("/deleteStudentRecord/{id}")
    public ResponseEntity<ResponseDTO> deleteStudentRecord(@PathVariable("id") int id) {
        istudentService.deleteStudentRecord(id);
        ResponseDTO responseDTO = new ResponseDTO("Student records clear of Id " + id + "", "Deleted id: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
