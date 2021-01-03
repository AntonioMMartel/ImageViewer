/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer;

import imageviewer.Mock.*;
import imageviewer.Models.*;
import imageviewer.View.*;
import imageviewer.control.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author Antonio Miguel Martel
 */
public class ImageViewer {


    public static void main(String[] args) {
        
        
        ImageRepository imageRepository = new ImageRepository();
        ImageDisplay imageDisplay = new MockImageDisplay(imageRepository);
        
        ImageListLoader imageListLoader = new MockImageLoader();
        imageRepository.add(imageListLoader.load());

        
        Command nextImage = new NextImageCommand(imageDisplay);
        Command prevImage = new PrevImageCommand(imageDisplay);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.next();
            if( input.equals("q")) break;
            if(input.equals("a")){
                prevImage.execute();
            }
            if(input.equals("d")){
                nextImage.execute();
            }
        }
        
    }

}
