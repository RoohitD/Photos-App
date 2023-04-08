package Classes;

import java.io.File;
import java.util.ArrayList;

/**
 * A User class for every user who runs the app
 * 
 *  Author: Rohit Deshmukh
 */
public class User {
    
    private String username;
    private String password;
    private static ArrayList<User> userList = new ArrayList<User>();
    private ArrayList<Photo> photoList = new ArrayList<Photo>();
    private ArrayList<Album> albumList = new ArrayList<Album>();


    /**
     * constructor to create new User instance
     * @param username
     * @param password
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
        userList.add(this);
    }

    public static User getUser(String username, String password){
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
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
     * 
     * @param username take a username to compare in database
     * @return boolean if it match
     */
    public boolean checkUsername(String username){
        String newUser = username;
        boolean returnVal = true;
        for(int x = 0; x < userList.size(); x++){
            if (userList.get(x).getUsername().equals(newUser)){
                returnVal = false;
            }
        }
        return returnVal;
    }


    /**
     * 
     * @param username take a username to check in system
     * @param password take a passport to chekc in system if its exist
     * @return boolean based on if the username and passport matches
     */
    public boolean checkUser(String username, String password){
        boolean credential = false;
        for(int x = 0; x < userList.size(); x++){
            if (userList.get(x).getUsername().equals(username) && userList.get(x).getPassword().equals(password)){
                credential = true;
                break;
            }
        }
        return credential;
    }
     

    /**
     * verifies if the user type matches the current user
     * @param user
     * @return
     * @throws Exception
     */
    public static boolean verifyUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addPhoto(String caption, File image, String[] tags){
        Photo photo = new Photo(caption, image, tags);
        photoList.add(photo);
    }

    public void createAlbum(String name, Photo[] photo){
        Album album = new Album(name, null);
        albumList.add(album);
    }   

    public String toString(){
        return "\nUsername: " + username + "\nPassword: " + password;
    }

    public int photoLength(){
        return photoList.size();
    }

}
