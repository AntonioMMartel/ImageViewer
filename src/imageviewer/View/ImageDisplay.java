/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.View;

import imageviewer.Models.Image;
import imageviewer.control.ImageRepository;

/**
 * @author Antonio Miguel Martel
 */
public interface ImageDisplay {
    
    public void display();
    
    public Image current();

    public int getIndex();

    public ImageRepository getImageRepository();

    public void setIndex(int i);
    
    
}
