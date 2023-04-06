package Classes;
import java.io.File;

/**
 *  A photo class for every photo created within the app
 * 
 *  Author Rohit Deshmukh
 */

public class Photo {
    
    private String caption;
    private File image;
    private String tags[];
    
    /**
     * constructor to create new Photo instance
     * @param caption
     * @param image
     * @param tags
     */
    public Photo(String caption, File image, String[] tags){
        this.caption = caption;
        this.image = image;
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
