/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author DavidTK1198
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Presentation.MainWindow.View vista = new Presentation.MainWindow.View();
        Presentation.MainWindow.Model model = new Presentation.MainWindow.Model();
        Presentation.MainWindow.Controller control = new Presentation.MainWindow.Controller(vista, model);
        vista.setVisible(true);
    }

}

