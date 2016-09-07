package com.chyld.controllers;

<<<<<<< HEAD
import com.chyld.entities.Exercise;
import com.chyld.entities.Profile;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.security.Principal;
=======
import com.chyld.dtos.AuthDto;
import com.chyld.entities.Exercise;
import com.chyld.entities.Profile;
import com.chyld.entities.Role;
import com.chyld.entities.User;
import com.chyld.enums.RoleEnum;
import com.chyld.security.JwtToken;
import com.chyld.utilities.JwtUtil;
import com.chyld.services.RoleService;
import com.chyld.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

<<<<<<< HEAD
    private ExerciseService service;

    @Autowired
    public void setExerciseService(ExerciseService exerciseService) {
        service = exerciseService;
=======
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Exercise> getExercises(Principal user) {
        int uid = ((JwtToken)user).getUserId();
<<<<<<< HEAD
        List<Exercise> exercises = service.findExcercisesByUser(uid);
        return exercises;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Exercise getExercise(@PathVariable int id, Principal user) {
        int uid = ((JwtToken)user).getUserId();
        Exercise exercise = service.findExcercise(uid, id);
        return exercise;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> saveExercise(@RequestBody Exercise exercise, Principal user) {
        int uid = ((JwtToken)user).getUserId();
        service.saveExcercise(uid, exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @RequestMapping(value =  {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteExercise(@PathVariable int id, Principal user) {
        int uid = ((JwtToken)user).getUserId();
        boolean success = service.deleteExcercise(uid, id);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<?> updateExercise(@RequestBody Exercise exercise,
                                            Principal user) {
        int uid = ((JwtToken) user).getUserId();
        boolean success = service.updateExcercise(uid, exercise);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
=======
        User u = userService.findUserById(uid);
        return u.getExercises();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Exercise createExercise(Principal user, @RequestBody Exercise exercise) {
        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);
        exercise.setUser(u);
        u.getExercises().add(exercise);
        userService.saveUser(u);
        return exercise;
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
    }
}
