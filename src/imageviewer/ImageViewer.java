/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer;

import imageviewer.Mock.MockImageDisplay;
import imageviewer.Mock.MockImageLoader;
import imageviewer.Models.Image;
import imageviewer.View.ImageDisplay;
import imageviewer.View.ImageListLoader;
import java.util.List;

/**
 * @author Antonio Miguel Martel
 */
public class ImageViewer {


    public static void main(String[] args) {
        ImageDisplay imageDisplay = new MockImageDisplay();
        ImageListLoader imageListLoader = new MockImageLoader();
        List<Image> lista = imageListLoader.load();
        imageDisplay.display(lista.get(0));
        
        
    }

}
