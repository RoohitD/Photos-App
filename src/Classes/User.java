package Classes;

/**
 * A User class for every user who runs the app
 * 
 *  Author: Rohit Deshmukh
 */
public class User {
    
    private String username;
    private String password;

    /**
     * constructor to create new User instance
     * @param username
     * @param password
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * returns the username of the user
     * @return
     */
    public String getUsername(){
        return username;
    }

    /**
     * returns the password of the user
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * verifies if the user type matches the current user
     * @param user
     * @return
     * @throws Exception
     */
    public boolean verifyUser(User user) throws Exception{
        if(user.getUsername().compareTo(this.username) != 0 ){
            throw new Exception("Invalid Username");
        } else if (user.getPassword().compareTo(this.password) != 0){
            throw new Exception("Invalid Password");
        } else if ((user.getUsername().compareTo(this.username) != 0) && (user.getPassword().compareTo(this.password) != 0)){
            return true;
        } else {
            return false;
        }
    }
}
