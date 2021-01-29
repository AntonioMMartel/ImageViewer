/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.control.commands;

import imageviewer.View.ImageDisplay;

/**
 * @author Antonio Miguel Martel
 */
public class PrevImageCommand implements Command {
    private final ImageDisplay imageDisplay;

    public PrevImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        imageDisplay.setIndex(imageDisplay.getIndex() - 1);
        if(imageDisplay.getIndex() < 0) 
            imageDisplay.setIndex(imageDisplay.getImageRepository().size() - 1);
        imageDisplay.display();
    }

    
    
}
