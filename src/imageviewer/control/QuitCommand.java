/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.control;

import static java.lang.System.exit;

/**
 *
 * @author Usuario
 */
public class QuitCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Cerrando aplicacion.");
        exit(0);
    }
    
    
    
}
