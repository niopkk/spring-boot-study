package com.bbz.server;

import com.bbz.model.CustomUser;

public interface CustomUserDetailsService {


    CustomUser findCustomUserByUserNameAndPassWord(String userName,String passWord);
}
