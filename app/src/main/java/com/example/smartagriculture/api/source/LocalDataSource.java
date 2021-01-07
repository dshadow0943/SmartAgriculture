package com.example.smartagriculture.api.source;

/**
 *
 */
public interface LocalDataSource {
    /**
     * 保存用户名
     */
    void saveUserName(String userName);

    /**
     * 保存用户密码
     */
    void savePassword(String password);

    /**
     * 保存用户登录账号
     */
    void saveLogin(String login);

    /**
     * 保存用户手机号
     */
    void saveStudentNumber(String studentNumber);

    /**
     * 保存token
     */
    void saveToken(String token);

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 获取用户登录账号
     */
    String getLogin();

    /**
     * 获取用户密码
     */
    String getPassword();

    /**
     * 获取用户手机号
     */
    String getStudentNumber();

    /**
     * 获取用户token
     */
    String getToken();
}
