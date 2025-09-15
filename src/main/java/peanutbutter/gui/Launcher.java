package peanutbutter.gui;

import peanutbutter.Juin;
import peanutbutter.exceptions.JuinException;

/**
 * Launches the Juin application by initializing the JavaFX runtime.
 */
public class Launcher {

    /**
     * Entry point for launching the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        try {
            Juin app = new Juin("data/juin.txt");
            app.run();
        } catch (JuinException e) {
            System.out.println("Error starting juin: " + e.getMessage());
        }
    }
}
