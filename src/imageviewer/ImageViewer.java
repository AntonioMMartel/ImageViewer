/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer;

import imageviewer.Mock.*;
import imageviewer.Models.*;
import imageviewer.View.*;
import imageviewer.control.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Antonio Miguel Martel
 */
public class ImageViewer {


    public static void main(String[] args) {
        
        ImageRepository imageRepository = initRepository();
        ImageDisplay imageDisplay = creatImageDisplay(imageRepository);
        Map<String, Command> commands = initCommands(imageDisplay);
        
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.next();
            //if (commands.containsKey(input)) commands.get(input).execute();
            commands.getOrDefault(scanner.next(), new NullCommand()).execute();
        }
        
    }
    
    private static Map<String, Command> initCommands(ImageDisplay imageDisplay) {
        Map<String, Command> commands = new HashMap<>();
        commands.put("d", new NextImageCommand(imageDisplay));
        commands.put("a", new PrevImageCommand(imageDisplay));
        commands.put("q", new QuitCommand());
        return commands;
    }
    
    private static ImageRepository initRepository(){
        ImageRepository imageRepository = new ImageRepository();
        ImageDisplay imageDisplay = new MockImageDisplay(imageRepository);
        
        ImageListLoader imageListLoader = new MockImageLoader();
        imageRepository.add(imageListLoader.load());
        
        return imageRepository;
    }
    
    private static ImageDisplay creatImageDisplay(ImageRepository imageRepository) {
        ImageDisplay imageDisplay = new MockImageDisplay(imageRepository);
        return imageDisplay;
    }
    
}
