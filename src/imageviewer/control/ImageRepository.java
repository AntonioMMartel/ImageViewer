package imageviewer.control;
import imageviewer.Models.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * @author Antonio Miguel Martel
 */
public class ImageRepository {
    // Solo tengo 1 repositorio de imagenes.
    private static final List<Image> imageList = new ArrayList<>();

    public static void add(Image image){
       imageList.add(image);
    }

    public ImageRepository() { }
    
    //Singleton pattern.
    private static class SingletonHelper {
        private static final ImageRepository INSTANCE = new ImageRepository();
    }
    
    public static ImageRepository getInstance() {
            return SingletonHelper.INSTANCE;
    }
    

    public static void add(List<Image> images){
       for (Image image : images) {
           imageList.add(image);
       }
    }

    public void remove(Image o) {
        imageList.remove(o);
    }
   
    public static Image get(int index) {
        return imageList.get(index);
    }

    public static int size() {
        return imageList.size();
    }
    
    public BufferedImage loadImage(int index) {
        try {
            return ImageIO.read(new File(ImageRepository.get(index).getName()));
        } catch (IOException e) {
            System.out.println("No se ha podido obtener la imagen de la carpeta de imagenes." + e.getMessage());
            System.out.println("Retornando un valor nulo.");
            return null;
        }
    }
    
    
    
    
    
    
    
}
