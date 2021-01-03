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
public class DeleteImageCommand implements Command{
    
    private final ImageDisplay imageDisplay;

    public DeleteImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        imageDisplay.getImageRepository().remove(imageDisplay.current());
        new NextImageCommand(imageDisplay).execute();
    }
    
    
    
}
