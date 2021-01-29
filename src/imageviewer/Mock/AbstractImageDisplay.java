/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.Mock;

import imageviewer.Models.Image;
import imageviewer.control.ImageRepository;
import imageviewer.View.ImageDisplay;

/**
 * @author Antonio Miguel Martel
 * 
 * Puede ser una interfaz? Pues si.
 * La cosa es que prefiero que todos mis displays hagan y tengan
 * esto como minimo.
 * 
 * No me sirve de nada porque ahora necesito otro extends con mi swingDisplay y
 * no puedo hacer na.
 */
public abstract class AbstractImageDisplay implements ImageDisplay {
    protected int index = 0;
    protected final ImageRepository imageRepository;

    public AbstractImageDisplay(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    
    // El como se va a mostrar la imagen si que depende de cada display
    public abstract void display();
    
    @Override
    public Image current() {
        return ImageRepository.get(index);
    }

    public int getIndex() {
        return index;
    }

    public ImageRepository getImageRepository() {
        return imageRepository;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
}
