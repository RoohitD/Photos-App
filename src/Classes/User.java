package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
        if(!checkUser(username, password)){
            userList.add(this);

        } else {
            throw new IllegalArgumentException();
        }
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
        return username + "\n" + password + "\n";
    }

    public int photoLength(){
        return photoList.size();
    }

    public static void writeList(){
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    public static void writeToFile(){
            try {
                // NOTE: Change the pathname of the file
                PrintWriter oos = new PrintWriter(new File("src/main/Users.txt"));
    
                for(int i = 0; i < userList.size(); i++){
                    oos.print(((User) userList.get(i)).toString());
                }
                oos.close();
            }  catch (IOException e3){
                System.out.println("File Not Found. (Write)");
            }
    }

    public static void readFromFile(){
        try{
            File file = new File("src/main/Users.txt");

            if(file.length() != 0){
                Scanner inFile = new Scanner(new FileReader(file));
                while (inFile.hasNext()){
                    String user = inFile.nextLine();
                    String pass = inFile.nextLine();
                    userList.add(new User(user, pass));
                }
                inFile.close();
            }
        } catch(FileNotFoundException e1){
            System.out.println("File Does not Exist. (Read)");
        }

    }

}
