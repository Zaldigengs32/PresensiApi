package com.example.presensiapi.controller;

import com.example.presensiapi.dto.DtoResponse;
import com.example.presensiapi.model.User;
import com.example.presensiapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/login")
    public DtoResponse login(
            @RequestBody Map<String, Object> parameter,
            @RequestHeader(value = "authcode", required = false) String authcode) {

        if (authcode == null) {
            return new DtoResponse(401, "Unauthorized - Missing Bearer Token", null);
        }

        if (!authcode.equals("astratech@123")) {
            return new DtoResponse(403, "Forbidden - Invalid Token", null);
        }

        String nim = parameter.get("nim").toString();
        String password = parameter.get("password").toString();

        User data = userRepository.findByMhsNimAndPassword(nim, password);

        if (data == null) {
            return new DtoResponse(501, "Not Found", null);
        }

        return new DtoResponse(200, "Data Found", data);
    }
}
