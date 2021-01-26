package service;

import model.User;

public class UserCreator {

    public static final String USER_LOGIN ="test.data.login";
    public static final String USER_PASSWORD="test.data.password";

    public static final String USER_LOGINN ="test.data.loginn";
    public static final String USER_PASSWORDD="test.data.passwordd";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(USER_LOGIN), TestDataReader.getTestData(USER_PASSWORD));
    }
    public static User withoutCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(USER_LOGINN), TestDataReader.getTestData(USER_PASSWORDD));
    }

}
