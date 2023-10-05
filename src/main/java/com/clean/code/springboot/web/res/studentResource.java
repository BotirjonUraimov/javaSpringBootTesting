package com.clean.code.springboot.web.res;

import com.clean.code.springboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentResource {

    @GetMapping("/students/all")
   public ResponseEntity getAll() {
        Student student = new Student(145546l, "Botir", "Uraimov", "Researcher" );
        Student student1 = new Student(2l, "Umar", "Uraimov", "Kindergarten" );
        Student student2 = new Student(3l, "Qodir", "Uraimov", "Researcher" );

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);

        return ResponseEntity.ok(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Student student = new Student(id, "Botir", "Uraimov", "Researcher" );
     return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getOneByParam(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course) {
        Student student = new Student(id, name, lastName, course );
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students")
    public ResponseEntity getOne(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity updateOne(@RequestBody Student newStudent) {
        Student student = new Student(145546l, "Botir", "Uraimov", "Researcher" );
        student.setName(newStudent.getName());
        student.setLastName(newStudent.getLastName());
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
    return ResponseEntity.ok("data deleted");

    }

}
