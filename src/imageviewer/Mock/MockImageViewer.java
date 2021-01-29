/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.Mock;

import imageviewer.control.commands.PrevImageCommand;
import imageviewer.control.commands.NullCommand;
import imageviewer.control.commands.QuitCommand;
import imageviewer.control.commands.NextImageCommand;
import imageviewer.control.commands.Command;
import imageviewer.control.ImageRepository;
import imageviewer.Models.*;
import imageviewer.View.*;
import imageviewer.control.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Antonio Miguel Martel
 */
public class MockImageViewer {


    public static void main(String[] args) {
        
        ImageRepository imageRepository = initRepository();
        AbstractImageDisplay imageDisplay = creatImageDisplay(imageRepository);
        Map<String, Command> commands = initCommands(imageDisplay);
        
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.next();
            //if (commands.containsKey(input)) commands.get(input).execute();
            commands.getOrDefault(input, new NullCommand()).execute();
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
        
        ImageListLoader imageListLoader = new MockImageLoader();
        ImageRepository.add(imageListLoader.load());
        
        return imageRepository;
    }
    
    private static AbstractImageDisplay creatImageDisplay(ImageRepository imageRepository) {
        AbstractImageDisplay imageDisplay = new MockImageDisplay(imageRepository);
        return imageDisplay;
    }
    
}
