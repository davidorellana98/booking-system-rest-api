package com.davidorellana.bookingsystemrestapi.auth.controller;

import com.davidorellana.bookingsystemrestapi.auth.dto.LoginDto;
import com.davidorellana.bookingsystemrestapi.auth.dto.TokenDto;
import com.davidorellana.bookingsystemrestapi.auth.security.jwt.OperationJwt;
import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import com.davidorellana.bookingsystemrestapi.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/auth")
public class AuthenticationController {

    private final OperationJwt operationJwt;
    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    public AuthenticationController(OperationJwt operationJwt, UserService userService) {
        this.operationJwt = operationJwt;
        this.userService = userService;
    }

    @Operation(summary = "Jwt generation to obtain the Token")
    @PostMapping
    public ResponseEntity<TokenDto> generateJwt(@RequestBody LoginDto loginDto) {
        User userFound = userService.findUserByEmail(loginDto.getEmail());
        if (userFound != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
            TokenDto tokenDto = operationJwt.generateTokenDto(userFound);
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        }
        return new ResponseEntity("Entry denied, due to incorrect credentials.", HttpStatus.NOT_FOUND);
    }
}
