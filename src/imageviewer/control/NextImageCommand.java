/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.control;

import imageviewer.View.ImageDisplay;

/**
 * @author Antonio Miguel Martel
 */
public class NextImageCommand implements Command{
    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.setIndex(imageDisplay.getIndex() + 1);
        if(imageDisplay.getIndex() >= imageDisplay.getImageRepository().size())
            imageDisplay.setIndex(0);
        imageDisplay.display();
    }


    
    
    
    
}
