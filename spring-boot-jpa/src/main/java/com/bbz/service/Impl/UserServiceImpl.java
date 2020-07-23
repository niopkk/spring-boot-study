package com.bbz.service.Impl;

import com.bbz.model.Grade;
import com.bbz.model.School;
import com.bbz.model.User;
import com.bbz.model.UserModel;
import com.bbz.repository.UserJPA;
import com.bbz.repository.UserRepository;
import com.bbz.search.Params;
import com.bbz.search.UserSearchTerm;
import com.bbz.service.UserService;

import com.bbz.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(int pageNum, int pageSize, User user) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return userRepository.findAll((Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (user.getUserId() != 0) {
                predicates.add(criteriaBuilder.like(root.get("userId").as(String.class), "%" + user.getUserId() + "%"));
            }
            if (user.getUserName() != null && !user.getUserName().equals("")) {
                predicates.add(criteriaBuilder.like(root.get("userName").as(String.class), "%" + user.getUserName() + "%"));
            }
            if (user.getGender() != 0) {
                predicates.add(criteriaBuilder.like(root.get("gender").as(String.class), "%" + user.getGender() + "%"));
            }
            if (user.getAge() != 0) {
                predicates.add(criteriaBuilder.like(root.get("age").as(String.class), "%" + user.getAge() + "%"));
            }
            Predicate[] pre = new Predicate[predicates.size()];
            criteriaQuery.where(predicates.toArray(pre));
            return criteriaBuilder.and(predicates.toArray(pre));
        }, pageable);

    }

    @Override
    public List<User> findAll(int pageNum, int pageSize, Params params) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                //根据userId 查询user
                if (params.getUserId() != 0) {
                    list.add(cb.equal(root.get("userId").as(String.class), params.getUserId()));
                }
                //Strings 模糊查询user
                if (Strings.isNotBlank(params.getUserName())) {
                    list.add(cb.like(root.get("userName").as(String.class), "%" + params.getUserName() + "%"));
                }
                //根据gender 查询user
                if (params.getGender() != 0) {
                    list.add(cb.equal(root.get("gender").as(String.class), params.getGender()));
                }
                //根据age>? 查询user
                if (params.getAge() != 0) {
                    list.add(cb.gt(root.get("age").as(Integer.class), Integer.valueOf(params.getAge())));
                }
                //根据gradeName 查询user
                if (Strings.isNotBlank(params.getGradeName())) {
                    Join<Grade, User> join = root.join("grade", JoinType.LEFT);
                    list.add(cb.equal(join.get("gradeName"), params.getGradeName()));
                }
                //根据schoolName 查询user
                if (Strings.isNotBlank(params.getSchoolName())) {
                    Join<School, User> join = root.join("grade", JoinType.LEFT);
                    list.add(cb.equal(join.get("school").get("schoolName"), params.getSchoolName()));
                }
                Predicate[] pre = new Predicate[list.size()];
                criteriaQuery.where(list.toArray(pre));
                return cb.and(list.toArray(pre));
            }
        }, pageable);
    }
}
