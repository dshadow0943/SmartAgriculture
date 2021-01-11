package com.example.smartagriculture.api.source.local;


import com.example.smartagriculture.utils.SPUtils;

/**
 * 本地数据源，可配合Room框架使用
 *
 */
public class LocalDataSource {
    private volatile static LocalDataSource INSTANCE = null;
    private static final String USER_NAME = "user_name";
    private static final String USER_LOGIN = "user_login";
    private static final String USER_PWD = "user_pwd";
    private static final String USER_PHONE = "user_phone";
    private static final String USER_TOKEN = "user_token";

    public static LocalDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSource();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalDataSource() {
        //数据库Helper构建
    }

    public void saveUserName(String userName) {
        SPUtils.getInstance().put(USER_NAME, userName);
    }

    public void savePassword(String password) {
        SPUtils.getInstance().put(USER_PWD, password);
    }

    public void saveLogin(String login) {
        SPUtils.getInstance().put(USER_LOGIN, login);
    }

    public void saveToken(String token) {
        SPUtils.getInstance().put(USER_TOKEN, token);
    }

    public String getUserName() {
        return SPUtils.getInstance().getString(USER_NAME);
    }

    public String getLogin() {
        return SPUtils.getInstance().getString(USER_LOGIN);
    }

    public String getPassword() {
        return SPUtils.getInstance().getString(USER_PWD);
    }

    public String getToken() {
        return SPUtils.getInstance().getString(USER_TOKEN);
    }
}
