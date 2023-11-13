/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import entity.mobile.Deplacement;
import view.ViewFrame;
import view.ViewPanel;


/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        ViewFrame viewFrame = new ViewFrame();
        Deplacement deplacement = new Deplacement();
        viewFrame.showWindow();
        deplacement.startGameThread();
    }
}
