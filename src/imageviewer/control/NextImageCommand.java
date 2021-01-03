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
        //Lo cambio. Es menos legible pero mas eficiente.
        // Que es mejor? Este cambio no me influye en casi nada
        // En esta caso siempre optamos por lo legible
        //Lo que tenia en la ver2 es mejor que lo que tengo ahora.
        imageDisplay.setIndex((imageDisplay.getIndex() + 1) % imageDisplay.getImageRepository().size());
        imageDisplay.display();
    }


    
    
    
    
}
