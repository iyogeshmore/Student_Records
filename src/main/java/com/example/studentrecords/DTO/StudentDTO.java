package com.example.studentrecords.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@RequiredArgsConstructor
public @ToString class StudentDTO {
    @NotNull(message = "Student name cannot be null.")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Student name invalid.")
    public String name;
    @NotNull(message = "Student age cannot be null.")
    public int age;
    @NotNull(message = "Student email cannot be null.")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Student name invalid.")
    public String email;
    @NotNull(message = "Address cannot be empty.")
    public String address;
}
