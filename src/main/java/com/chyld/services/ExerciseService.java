package com.chyld.services;

import com.chyld.entities.Exercise;
import com.chyld.entities.User;
import com.chyld.repositories.IExcerciseRepository;
import com.chyld.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private IExcerciseRepository repository;
    private IUserRepository userRepository;

    @Autowired
    public void setRepository(IExcerciseRepository repository) {this.repository = repository;}

    @Autowired
    public void setUserRepository(IUserRepository repository) {this.userRepository = repository;}

    public List<Exercise> findExcercisesByUser(int userId) {
        User user = new User();
        user.setId(userId);
        return  repository.findByUser(user);
    }

    public void saveExcercise(int userId, Exercise exercise) {

//        User u = userRepository.findOne(userId);
//
//        if(u.getE() == null){
//            u.setProfile(profile);
//            profile.setUser(u);
//        } else {
//            u.getProfile().setAge(profile.getAge());
//            u.getProfile().setGender(profile.getGender());
//            u.getProfile().setPhoto(profile.getPhoto());
//            u.getProfile().setHeight(profile.getHeight());
//            u.getProfile().setWeight(profile.getWeight());
//        }
//
//        userService.saveUser(u);

        User user = new User();
        user.setId(userId);

        exercise.setUser(user);
        repository.save(exercise);

    }

}
