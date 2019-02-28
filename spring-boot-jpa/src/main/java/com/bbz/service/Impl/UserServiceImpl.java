package com.bbz.service.Impl;

import com.bbz.model.UserModel;
import com.bbz.repository.UserJPA;
import com.bbz.search.UserSearchTerm;
import com.bbz.service.UserService;

import com.bbz.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserJPA userJPA;

    public List<UserModel> findUserAll() {
        return userJPA.findAll();
    }

    public List<UserModel> findUserAll(final UserSearchTerm term) {
        return userJPA.findAll();
    }



    public Predicate toPredicate(Root<UserModel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder,UserSearchTerm term) {
        List<Predicate> predicates = new ArrayList<Predicate>();
//                predicates.add(root.get("id").isNotNull());
        if (Strings.isNoneBlank(term.getName())) {
            predicates.add(builder.like(root.get("name").as(String.class), "%" + term.getName() + "%"));
        }
        if (term.getAge() > 600) {
            predicates.add(builder.between(root.get("age").as(Integer.class), term.getAge(), term.getAge()));
        }

        return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
    }
//
//    class test<T>{
//
//        private Predicate predicate;
//
//        private CriteriaBuilder builder;
//
//        protected test<T> apply(Supplier<?> supplier) {
//            supplier.get();
//            return this;
//        }
//
//        public test<T> ilike(String property, String keyword) {
//            return this.apply(() -> {
////                Expression<String> x, Expression<String> pattern
//                Root<T> root = null;
//                return this.builder.like(root.get(property), keyword);
//            });
//        }
//    }



    public UserModel findUserById(int id) {

        return userJPA.findUserById(id);
    }


    public void save(UserModel userModel) {
        userJPA.save(userModel);
    }
}
