package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {

}
