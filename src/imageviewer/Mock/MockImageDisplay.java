/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.Mock;

import imageviewer.Models.Image;
import imageviewer.View.ImageDisplay;

/**
 * @author Antonio Miguel Martel
 */
public class MockImageDisplay implements ImageDisplay{

    @Override
    public void display(Image image) {
        System.out.println(image.getName());
    }
    
    
    
}
