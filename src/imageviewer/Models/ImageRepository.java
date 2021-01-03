/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Miguel Martel
 */
public class ImageRepository {
    // Solo tengo 1 repositorio de imagenes.
    private static final List<Image> imageList = new ArrayList<>();
    
   public static void add(Image image){
       imageList.add(image);
   }
   
   public static void add(List<Image> images){
       for (Image image : images) {
           imageList.add(image);
       }
   }
   
    public static Image get(int index) {
        return imageList.get(index);
    }
    
    public static int size() {
        return imageList.size();
    }
}
