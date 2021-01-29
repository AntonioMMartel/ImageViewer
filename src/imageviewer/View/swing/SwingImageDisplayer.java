/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageviewer.View.swing;

import imageviewer.Models.Image;
import imageviewer.control.ImageRepository;
import imageviewer.View.ImageDisplay;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * @author Antonio Miguel Martel
 */

public final class SwingImageDisplayer extends JPanel implements ImageDisplay {
    private BufferedImage currentImage, nextImage;
    private int offset, index, nextIndex = 0;
    
    protected final ImageRepository imageRepository;
    
    public SwingImageDisplayer(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        MouseHandler mouseHandler = new MouseHandler();
        super.addMouseListener(mouseHandler);
        super.addMouseMotionListener(mouseHandler);
        display();
    }
    
        @Override
    public Image current() {
        return imageRepository.get(index);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public ImageRepository getImageRepository() {
        return imageRepository;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (currentImage == null) return;
        g.drawImage(currentImage, offset, 0, null);
        
        if (offset == 0) return;
        
        int valueOffset = currentImage.getWidth() + offset;
        if (offset >= 0) valueOffset = -(nextImage.getWidth() - offset);        
        
        g.drawImage(nextImage, valueOffset, 0, null);
    }
    
    @Override
    public void display() {
        this.currentImage = imageRepository.loadImage(index);
        repaint();
    }

    private void setOffset(int offset) {
        this.offset = offset;
        
        if (offset < 0){
            int prevImageIndex = (index - 1) < 0 ? ImageRepository.size() - 1 : index - 1;
            setNextImage(prevImageIndex);
        } else if (offset > 0){
            int nextImageIndex = (index + 1) % ImageRepository.size();
            setNextImage(nextImageIndex);
        }
        repaint();
    }
    
    private void setNextImage(int index) {
        this.nextImage = imageRepository.loadImage(index);
        nextIndex = index;
    }
    
    private void switchToNextImage() {
        this.currentImage = this.nextImage;
        index = nextIndex;
        setOffset(0);
    }
    
    private class MouseHandler implements MouseListener, MouseMotionListener {
        private int initial;
        
        @Override
        public void mouseClicked(MouseEvent event) {
        }

        @Override
        public void mousePressed(MouseEvent event) {
            initial = event.getX();
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            if (Math.abs(offset) > getWidth() / 2) switchToNextImage();
            else setOffset(0);
        } 

        @Override
        public void mouseEntered(MouseEvent event) {
        }

        @Override
        public void mouseExited(MouseEvent event) {
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            setOffset(event.getX() - initial);
        }

        @Override
        public void mouseMoved(MouseEvent event) {
        }
    }
    
    
}
