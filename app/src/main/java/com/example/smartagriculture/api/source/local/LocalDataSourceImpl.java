package com.example.smartagriculture.api.source.local;


import com.example.smartagriculture.api.source.LocalDataSource;

/**
 * 本地数据源，可配合Room框架使用
 *
 */
public class LocalDataSourceImpl implements LocalDataSource {
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalDataSourceImpl() {
        //数据库Helper构建
    }


    @Override
    public void saveUserName(String userName) {

    }

    @Override
    public void savePassword(String password) {

    }

    @Override
    public void saveLogin(String login) {

    }

    @Override
    public void saveStudentNumber(String studentNumber) {

    }

    @Override
    public void saveToken(String token) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getLogin() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getStudentNumber() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }
}
