package com.app.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.security.JwtUtil;
import com.app.service.AuthService;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin("http://localhost:5173")
public class AuthController {

	private final AuthService service;
	private final JwtUtil jwtUtil;
	private final UserRepository userRepository;

	public AuthController(AuthService service, JwtUtil jwtUtil, UserRepository userRepository) {
		this.service = service;
		this.jwtUtil = jwtUtil;
		this.userRepository = userRepository;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
		try {
			service.register(body.get("username"), body.get("password"));
			return ResponseEntity.ok("User registered successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
		try {
			User user = service.login(body.get("username"), body.get("password"));

			// Generate JWT token
			String token = jwtUtil.generateToken(user.getUsername());

			// Return token and userId
			return ResponseEntity.ok(Map.of("token", token, "userId", user.getId()));

		} catch (RuntimeException e) {
			return ResponseEntity.status(401).body(e.getMessage());
		}
	}
}
