package com.chyld.controllers;

import com.chyld.entities.Exercise;
import com.chyld.entities.Profile;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private ExerciseService service;

    @Autowired
    public void setExerciseService(ExerciseService exerciseService) {
        service = exerciseService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Exercise> getExercises(Principal user) {
        int uid = ((JwtToken)user).getUserId();
        List<Exercise> exercises = service.findExcercisesByUser(uid);
        return exercises;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> saveExercise(@RequestBody Exercise exercise, Principal user) {
        int uid = ((JwtToken)user).getUserId();
        service.saveExcercise(uid, exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
