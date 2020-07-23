package com.bbz.repository;

import com.bbz.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {



    List<User> findAll();

    List<User> findAll(Specification<User> spc, Pageable pageable);
}
