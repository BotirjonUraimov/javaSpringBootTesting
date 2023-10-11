package com.clean.code.springboot.web.res;

import com.clean.code.springboot.domain.User;
import com.clean.code.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {
    public final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user) {
        User user1 = userService.save(user);
        return ResponseEntity.ok(user1);
    }
    @GetMapping("/user/all")
    public  ResponseEntity getAllUser() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity getUserById(@RequestBody String email) {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }


}
