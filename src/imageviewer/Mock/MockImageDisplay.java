/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.Mock;

import imageviewer.control.ImageRepository;

/**
 * @author Antonio Miguel Martel
 */
public class MockImageDisplay extends AbstractImageDisplay{

    public MockImageDisplay(ImageRepository imageRepository) {
        super(imageRepository);
    }
    
    
    @Override
    public void display() {
        System.out.println(this.current().getName());
    }

    
    
    
}
