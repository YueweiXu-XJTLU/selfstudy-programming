package P199_Case_DynamicProxy;

public interface UserService {
    //Log in
    void login(String logInName, String password) throws Exception;

    //Delete users
    void deleteUsers() throws Exception;

    //Select users
    String[] selectUsers() throws Exception;
}
