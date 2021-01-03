/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.View;

import imageviewer.Models.Image;
import imageviewer.Models.ImageRepository;

/**
 * @author Antonio Miguel Martel
 * 
 * Puede ser una interfaz? Pues si.
 * La cosa es que prefiero que todos mis displays hagan y tengan
 * esto como minimo.
 */
public abstract class ImageDisplay {
    int index = 0;
    protected final ImageRepository imageRepository;

    public ImageDisplay(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    
    // El como se va a mostrar la imagen si que depende de cada display
    public abstract void display();
    
    public Image current() {
        return imageRepository.get(index);
    }

    //Implementar los comandos aqui es hacer el tonto porque voy
    //a usar el patron command.
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
