package com.bbz.适配器模式;

public class PassportForThird extends SiginService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String username) {
        return processLogin(username, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForSina(String username) {
        return processLogin(username, LoginForSinaAdapter.class);
    }


    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clz) {
        try {
            LoginAdapter loginAdapter = clz.newInstance();
            if (loginAdapter.support(key)) {
                return loginAdapter.login(key, loginAdapter);
            } else {
                return null;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
