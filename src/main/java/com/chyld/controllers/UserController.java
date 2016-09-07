package com.chyld.controllers;

import com.chyld.dtos.AuthDto;
<<<<<<< HEAD
=======
import com.chyld.dtos.UserDto;
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
import com.chyld.entities.Role;
import com.chyld.entities.User;
import com.chyld.enums.RoleEnum;
import com.chyld.security.JwtToken;
import com.chyld.services.RoleService;
import com.chyld.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
=======
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
<<<<<<< HEAD
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

@RestController
=======
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
public class UserController {

    private static final String EMAIL_EXISTS_MESSAGE = "This email is in use";

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(final UserService userService, final PasswordEncoder encoder, final RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = encoder;
        this.roleService = roleService;
    }

<<<<<<< HEAD
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody AuthDto auth) throws JsonProcessingException {
=======
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody AuthDto auth) {
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
        final String requestedEmail = auth.getUsername();

        UserDetails ud =  userService.loadUserByUsername(requestedEmail);
        if (ud != null) {
            return ResponseEntity.badRequest().body(EMAIL_EXISTS_MESSAGE);
        }

        User user = new User();
        user.setEnabled(true);
        user.setUsername(auth.getUsername());
        user.setPassword(passwordEncoder.encode(auth.getPassword()));

        user.setRoles(new ArrayList<>());
        Role r = roleService.findByRole(RoleEnum.USER);
        user.getRoles().add(r);

        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

<<<<<<< HEAD
    @RequestMapping(path = {"/users/", "/users"}, method = RequestMethod.GET)
    public Page<User> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page, Principal principal) {
        return this.userService.findAll(page);
    }



    @Transactional
    @RequestMapping(value = "/users/{username}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String username, Principal adminPrincipal) throws JsonProcessingException {
        int uid = ((JwtToken)adminPrincipal).getUserId();

        User adminuser =  userService.findUserById(uid);

        List<Role> adminRoles = adminuser.getRoles();

        boolean isAdmin = false;
        for (Role role: adminRoles) {
            if(role.getRole().equals(RoleEnum.ADMIN)) {
                isAdmin = true;
            }
        }

        if(!isAdmin) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        userService.deleteByUsername(username);

        return ResponseEntity.status(HttpStatus.OK).body(null);

=======
    @RequestMapping(value = "/credentials", method = RequestMethod.GET)
    public UserDto credentials(Principal user) {
        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);
        List<String> roles = u.getRoles().stream().map(r -> r.getRole().toString()).collect(Collectors.toList());
        UserDto userDto = new UserDto(u.getUsername(), roles);
        return userDto;
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
    }
}
