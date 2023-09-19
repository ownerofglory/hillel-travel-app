package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.service.UserService;

//@Controller
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = {HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE})
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    public @ResponseBody
    String hello() {
        return "Hello";
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) throws EntityNotFoundException {
        UserDTO userById = userService.getUserById(id);

        return ResponseEntity.ok(userById);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<UserDTO>  add(@RequestBody UserDTO userDTO) {
        UserDTO addedUser = userService.addUser(userDTO);

        return ResponseEntity.ok(addedUser);
    }
}
