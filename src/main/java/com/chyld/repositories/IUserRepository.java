package com.chyld.repositories;

import com.chyld.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {
    public User findByUsername(String username);
<<<<<<< HEAD
    public Long deleteByUsername(String username);
=======
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
}
