/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.View.swing;

import imageviewer.Models.Image;
import imageviewer.View.ImageListLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Miguel Martel
 */
public class FileImageLoader implements ImageListLoader {
    private final File directory;

    public FileImageLoader(File folder) {
        this.directory = folder;
    }
    
    @Override
    public List<Image> load() {
        List<Image> images = new ArrayList<>();
        File[] files = directory.listFiles(withExtension(".jpg", ".png"));
        
        for (File file : files) {
            images.add(new Image(file.getAbsolutePath()));
        }
        
        return images;
    }

    private FilenameFilter withExtension(String ... extensions) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if (name.endsWith(extension)) return true;
                }
                
                return false;
            }
        };
    }

}
