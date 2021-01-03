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
import java.util.Scanner;

/**
 * @author Antonio Miguel Martel
 */
public class ImageViewer {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ImageDisplay imageDisplay = new MockImageDisplay();
        ImageListLoader imageListLoader = new MockImageLoader();
        List<Image> lista = imageListLoader.load();
        imageDisplay.display(lista.get(0));
        int index = 0;
        while(true){
            String input = scanner.next();
            if( input.equals("q")) break;
            if(input.equals("d")){
                index++;
                if(index >= lista.size()) index=0;
                imageDisplay.display(lista.get(index));
            }
            if(input.equals("a")){
                index--;
                if(index < 0) index=lista.size() - 1;
                imageDisplay.display(lista.get(index));
            }
        }
        
    }

}
