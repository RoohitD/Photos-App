package Classes;

import java.util.ArrayList;

public class Album {
    
    private String albumName;
    private ArrayList<Photo> photos = new ArrayList<Photo>();


    public Album(String albumName, Photo[] photo){
        this.albumName = albumName;
        for(int i = 0; i < photo.length; i++){
            photos.add(photo[i]);
        }
    }

    public void addToAlbum(Photo photo){
        photos.add(photo);
    }

    public String getAlbumName(){
        return albumName;
    }

    public void removeFromAlbum(Photo photo){
        if(photos.contains(photo)){
            photos.remove(photo);
        }
    }


}
