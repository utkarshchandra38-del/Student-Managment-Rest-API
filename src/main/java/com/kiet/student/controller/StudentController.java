
package com.kiet.student.controller;

import com.kiet.student.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(101, "Rahul Sharma", "rahul@kiet.edu",
                    "CSE", 2, 8.65),
            new Student(102, "Priya Verma", "priya@kiet.edu",
                    "CSE(AI & ML)", 2, 9.10),
            new Student(103, "Aman Singh", "aman@kiet.edu",
                    "ECE", 3, 8.20),
            new Student(104, "Neha Gupta", "neha@kiet.edu",
                    "CSE", 2, 9.25),
            new Student(105, "Arjun Kumar", "arjun@kiet.edu",
                    "IT", 1, 7.90)
    ));

    // Q3A: Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // Q3B: Get student by ID
    @GetMapping("/{studentId}")
    public Object getStudentById(@PathVariable int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                return s;
            }
        }

        return Map.of("message", "Student not found");
    }

    // Q4: Add a student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // Q5A: Update a student
    @PutMapping("/{studentId}")
    public Object updateStudent(
            @PathVariable int studentId,
            @RequestBody Student updatedStudent) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                updatedStudent.setStudentId(studentId);
                students.set(i, updatedStudent);
                return updatedStudent;
            }
        }

        return Map.of("message", "Student not found");
    }

    // Q5B: Delete a student
    @DeleteMapping("/{studentId}")
    public Map<String, String> deleteStudent(
            @PathVariable int studentId) {

        boolean removed = students.removeIf(
                s -> s.getStudentId() == studentId);

        if (removed) {
            return Map.of(
                    "message", "Student deleted successfully");
        }

        return Map.of("message", "Student not found");
    }

    // Q6A: Search by branch and year
    @GetMapping("/search")
    public List<Student> searchStudents(
            @RequestParam String branch,
            @RequestParam int year) {

        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getBranch().toLowerCase()
                    .contains(branch.toLowerCase())
                    && s.getYear() == year) {
                result.add(s);
            }
        }

        return result;
    }

    // Q6B: Find students above minimum CGPA
    @GetMapping("/topper")
    public List<Student> getToppers(
            @RequestParam double cgpa) {

        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getCgpa() >= cgpa) {
                result.add(s);
            }
        }

        return result;
    }
}
