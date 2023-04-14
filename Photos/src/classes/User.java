package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
    @author Rohit Deshmukh
    Represents a user in the photo album management system.
*/


public class User implements Serializable {
    private String username;
    private String password;
    private static ArrayList<User> userList = new ArrayList<User>();
    private ArrayList<Album> albumList = new ArrayList<Album>();
    public static User currentUser;


    public User(){}

    /**
     * Constructs a new user with the given username and password. If the username is already taken,
     * an IllegalArgumentException is thrown.
     *
     * @param username the username of the user to be created
     * @param password the password of the user to be created
     * @throws IllegalArgumentException if the username is already taken
     */
    public User(String username, String password){
        if(verifyUser(username, password) == false){
            this.username = username;
            this.password = password;
            albumList.add(new Album("All Photos", null));
            createStockAlbum();
            userList.add(this);
            save();
        } else {
            throw new IllegalArgumentException("Account Already Exists.");
        }
    }

    /**
     * Gets a list of all users in the system.
     *
     * @return an ArrayList of all users in the system
     */
    public static ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * Gets a list of all albums owned by this user.
     *
     * @return an ArrayList of all albums owned by this user
     */
    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    /**
     * Gets the password of this user.
     *
     * @return the password of this user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username of this user.
     *
     * @return the username of this user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Verifies if a user with the given username and password exists in the system.
     *
     * @param username the username to be verified
     * @param password the password to be verified
     * @return true if a user with the given username and password exists, false otherwise
     */
    public static boolean verifyUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new photo to the user's default "All Photos" album.
     *
     * @param caption the caption of the photo to be added
     * @param image the image file of the photo to be added
     * @param tags a String representation of the tags of the photo to be added
     */
    public void addPhoto(String caption, File image, String tags){
        albumList.get(0).addPhotoToAlbum(new Photo(caption, image, tags));
        save();
    }

    /**
     * Creates a new album with the given name and photos for this user.
     *
     * @param albumName the name of the new album
     * @param albumPhotosUser the list of photos to be added to the new album
     */
    public void createAlbum(String albumName, ArrayList<Photo> albumPhotosUser) {
        albumList.add(new Album(albumName, albumPhotosUser));
        save();
    }

    /**
     * Returns the user object if the given username and password match a user in the system.
     * @param username the username to search for
     * @param password the password to search for
     * @return the user object if the user exists, null otherwise
     */
    public static User getUser(String username, String password){
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
    * Returns the album with the given album name for this user.
    * @param albumname the name of the album to search for
    * @return the album with the given album name for this user; null if not found
    */
    public Album getAlbum(String albumname){
        for (int i = 0; i < albumList.size(); i++) {
            if(albumList.get(i).getAlbumName().compareTo(albumname) == 0){
                return albumList.get(i);
            }
        }
        return null;
    }

    /**
    * Creates the "stock" album with default photos for this user.
    */
    public void createStockAlbum(){
        ArrayList<Photo> stocks = new ArrayList<Photo>();
        File folder = new File("src/stock");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (isImageFile(file)) {
                    String caption = file.getName();
                    stocks.add(new Photo(caption, file, "Stock: stock"));
                }
            }
        }
        this.createAlbum("stock", stocks);
    }

    /**
     * Checks if the file is an image
     * @param file
     * @return
     */
    private boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith("*.bmp");
    }

    /**
     * Returns the username of the user
     * @return username
     */
    public String toString(){
        return username;
    }

    /**
     * Remove the album from the albumList
     * @param album
     */
    public void removeAlbum(Album album){
        albumList.remove(album);
        save();
    }

    /**
     * 
     */
    public static void save(){
        File dir = new File(System.getProperty("user.home") + "/Desktop/user_List");

        if(!dir.exists()){  dir.mkdirs(); }

        for (User user : userList) {
            try {
                    FileOutputStream fileOut = new FileOutputStream(dir + "/" + user.getUsername() + ".ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(user);
                    out.close();
                    fileOut.close();
            } catch (Exception e) {
                System.out.print("Couldn't create file" + e);
            }
        }
    }

    /**
     * 
     */
    public static void load(){
        File dir = new File(System.getProperty("user.home") + "/Desktop/user_List");
        for(File file: dir.listFiles()){
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                User user = (User) in.readObject();
                userList.add(user);
                in.close();
                fileIn.close();
            } catch (Exception e) {
                System.out.println("Could load user" + e);
            }         
        }
    }

    /**
     * 
     * @param user
     */
    public static void delete(User user){
        File dir = new File(System.getProperty("user.home") + "/Desktop/user_List/" + user.username + ".ser");
        if(dir.exists()){
            dir.delete();
        }
    }
}

