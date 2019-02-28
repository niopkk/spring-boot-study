package com.lesson;

public class UserDaoFactory {

//    /**
//     * 未改之前
//     * @return
//     */
//    public static UserDao createUserDao() {
//        return new MemoryUserDao();
//    }


    /**
     * @return
     */

    public static UserDao createUserDao(Class<?> classzz) {
        String clsssName = "";
        UserDao userDao = null;
        try {
            userDao = (UserDao) classzz.newInstance();
            System.out.println(Class.forName("com.lesson.MemoryUserDao").newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDao;
    }


}
