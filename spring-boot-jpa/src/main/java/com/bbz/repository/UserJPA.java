package com.bbz.repository;

import com.bbz.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends JpaRepository<UserModel, Integer>, JpaSpecificationExecutor<UserModel>, Serializable {

    UserModel findUserById(int id);
}
