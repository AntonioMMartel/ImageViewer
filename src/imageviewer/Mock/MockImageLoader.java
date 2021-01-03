/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.Mock;

import imageviewer.Models.Image;
import imageviewer.View.ImageListLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Miguel Martel
 */
public class MockImageLoader implements ImageListLoader{

    
    @Override
    public List<Image> load() {
        List<Image> list = new ArrayList<>();
        list.add(new Image("Manolo"));
        list.add(new Image("Federico"));
        list.add(new Image("Rutherfodio"));
        list.add(new Image("Pepe"));
        list.add(new Image("Alabarda"));
        return list;
    }
    
    
    
}
