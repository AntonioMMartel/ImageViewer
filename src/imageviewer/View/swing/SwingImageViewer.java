/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.View.swing;

import imageviewer.Models.Image;
import imageviewer.Models.ImageRepository;
import imageviewer.control.Command;
import imageviewer.control.NextImageCommand;
import imageviewer.control.PrevImageCommand;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * @author Antonio Miguel Martel
 */
public class SwingImageViewer extends JFrame {
    private SwingImageDisplayer imageDisplayer;
    private final Map<String, Command> commands = new HashMap<>();
    
    public static void main(String[] args) {
        new SwingImageViewer().execute();
    }
    
    private void execute() {
        super.setVisible(true);
    }
    
    public SwingImageViewer() {
        
        super.setTitle("Image Viewer");
        super.setSize(800, 600);
        super.setLocation(300, 300);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        super.getContentPane().add(imageDisplay());
        super.add(toolbar(), BorderLayout.SOUTH);
       
        
        this.commands.put("prev", new PrevImageCommand(imageDisplayer));
        this.commands.put("next", new NextImageCommand(imageDisplayer));
        
    }
    
    private SwingImageDisplayer imageDisplay() {
        SwingImageDisplayer swingImageDisplayer = new SwingImageDisplayer(loadRepository());
        this.imageDisplayer = swingImageDisplayer;
        return swingImageDisplayer;
    }
    
    

    private ImageRepository loadRepository() {
        ImageRepository repo = new ImageRepository();
        ImageRepository.add(loadImages());
        return repo;
    }

    private List<Image> loadImages() {
        return (List<Image>) new FileImageLoader(new File("images")).load();
    }

    private JMenuBar toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.setLayout(new FlowLayout(CENTER));
        
        toolbar.add(button("prev"));
        toolbar.add(button("next"));
        
        return toolbar;
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
        });
        
        return button;
        
    }
    
    
    
    
}
