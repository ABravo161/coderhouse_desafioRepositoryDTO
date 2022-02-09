package com.coderhouse.controller;
import com.coderhouse.model.database.document.UserDocument;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coder-house")
public class UserController {

    private final UserService service;

    @PostMapping("/users")
    public UserResponse createProduct(
            @Validated @RequestBody UserRequest product) {
        return service.create(product);
    }


    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable String id){
        return service.getUser(id);
    }


    @GetMapping("/users/all")
    public List<UserResponse> searchProduct() {
        return service.searchAll();
    }
}
