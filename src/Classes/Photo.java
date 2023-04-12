package Classes;
import java.io.File;
import java.util.Date;

import javafx.scene.image.Image;

/**
 *  A photo class for every photo created within the app
 * 
 *  Author Rohit Deshmukh
 */

public class Photo {
    
    private String caption;
    private File image;
    private String tags[];
    private Date date;
    
    /**
     * constructor to create new Photo instance
     * @param caption
     * @param image
     * @param tags
     */
    public Photo(String caption, File image, Date date, String[] tags){
        this.caption = caption;
        this.image = image;
        this.date = date;
        this.tags = tags;
    }

    /**
     * returns the caption of the Photo
     * @return
     */
    public String getCaption(){
        return caption;
    }

    /**
     * returns the image of the Photo
     * @return
     */
    public File getImage(){
        return image;
    }

    /**
     * returns the tags of the Photo
     * @return
     */
    public String[] getTags(){
        return tags;
    }

}
