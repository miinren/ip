package peanutbutter.gui;

import javafx.application.Application;
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
        Application.launch(Main.class, args);
    }
}
