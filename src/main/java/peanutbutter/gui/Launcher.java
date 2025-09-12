package peanutbutter.gui;

import peanutbutter.Juin;
import peanutbutter.exceptions.JuinException;

public class Launcher {
    public static void main(String[] args) {
        try {
            Juin app = new Juin("data/juin.txt");
            app.run();
        } catch (JuinException e) {
            System.out.println("Error starting juin: " + e.getMessage());
        }
    }
}
