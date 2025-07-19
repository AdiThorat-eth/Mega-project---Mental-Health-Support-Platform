package com.mantra.service;

import com.mantra.dto.auth.AuthResponse;
import com.mantra.dto.auth.LoginRequest;
import com.mantra.dto.auth.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}