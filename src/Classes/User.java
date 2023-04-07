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

}
