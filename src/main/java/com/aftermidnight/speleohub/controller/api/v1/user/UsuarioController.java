package com.aftermidnight.speleohub.controller.api.v1.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aftermidnight.speleohub.model.User;
import com.aftermidnight.speleohub.repository.UserRepository;
import com.aftermidnight.speleohub.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UserService service;
    private final UserRepository repo;

    @GetMapping("/all")
    public List<User> getAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public User get(@RequestBody Long id){
        return repo.findById(id).orElseThrow();
    }

    @PostMapping("/register")
    public User register(@RequestBody @Valid User user){
        // return service.register(user);
        return new User();
    }

	@PostMapping(value={ "/new","/{id}"})
    public User save(@RequestBody @Valid User user){
        return repo.save(user);
    }
}
