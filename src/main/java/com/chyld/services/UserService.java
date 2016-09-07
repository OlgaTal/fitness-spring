package com.chyld.services;

import com.chyld.entities.User;
import com.chyld.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
=======
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private IUserRepository repository;

    @Autowired
    public void setRepository(IUserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User findUserById(Integer id) {
        return repository.findOne(id);
    }

<<<<<<< HEAD
    public Long deleteByUsername(String username) { return repository.deleteByUsername(username); };


=======
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByUsername(username);
    }
<<<<<<< HEAD

    public Page<User> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }
=======
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
}
