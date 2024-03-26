package ru.real.backend.impl.util.auth;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.real.backend.api.dto.auth.AuthenticationRequest;
import ru.real.backend.api.dto.auth.AuthenticationResponse;
import ru.real.backend.api.dto.auth.RegistrationRequest;
import ru.real.backend.core.exception.UserAlreadyExistsException;
import ru.real.backend.core.exception.UserNotFoundException;
import ru.real.backend.core.util.auth.JwtUtils;
import ru.real.backend.impl.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    public AuthenticationResponse authenticate(@NotNull AuthenticationRequest request) {
        if (userService.isExists(request.getUsername())) {
            final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(), userDetails.getAuthorities()));
            return new AuthenticationResponse(jwtUtils.generateToken(userDetails), "");
        }
        throw new UserNotFoundException();
    }

    public AuthenticationResponse register(@NotNull RegistrationRequest request) {
        if (!userService.isExists(request.getUsername())) {
            final UserDetails userDetails = userService.save(request);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(), userDetails.getAuthorities()));
            return new AuthenticationResponse(jwtUtils.generateToken(userDetails), "");
        }
        throw new UserAlreadyExistsException();
    }
}
