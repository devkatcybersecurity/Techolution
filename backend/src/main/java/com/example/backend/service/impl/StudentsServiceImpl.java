package com.example.backend.service.impl;

import com.example.backend.dao.Students;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ApiError;
import com.example.backend.repository.StudentsRepository;
import com.example.backend.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;


    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public Students getStudentById(Integer id) {
        Students students = studentsRepository.findById(id).orElseThrow(
                () -> new CustomException("Student with id " + id + " not found", HttpStatus.NOT_FOUND));
        return students;
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }


    @Override
    public Students addStudent(Students student) {
        return studentsRepository.save(student);
    }

    @Override
    public Students updateStudent(Integer studentId, Students student) {


//        Students oldStudentData = studentsRepository.findById(studentId).orElseThrow(
//                () -> new CustomException(ApiError.STUDENT_NOT_FOUND.getApiError(), ApiError.STUDENT_NOT_FOUND.getErrorMessage()));
//            Students newStudentData = Students.builder()
//                    .studentId(studentId)
//                    .firstName(student.getFirstName() != null ? student.getFirstName() : oldStudentData.getFirstName())
//                    .lastName(student.getLastName() != null ? student.getLastName() : oldStudentData.getLastName())
//                    .groupId(student.getGroupId() != null ? student.getGroupId() : oldStudentData.getGroupId())
//                    .build();
//            return studentsRepository.save(newStudentData);

        return null;

    }


    @Override
    public void deleteStudent(Integer id) {
        try{
            studentsRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new CustomException("Student with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

}

