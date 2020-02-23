package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.View.Renderer;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemListener;

public class ControllerFactory {

    private GLJPanel gljPanel;
    private Renderer renderer;

    private ControllerFactory(){

    }


    private static ItemListener createJComboBoxWithAlpha(GLJPanel gljPanel, Renderer renderer){
        return new JComboBoxWithAlphaController(gljPanel, renderer);
    }

    private static ItemListener createJComboBoxWithPrimitives(GLJPanel gljPanel, Renderer renderer){
        return new JComboBoxWithPrimitivesController(gljPanel, renderer);
    }

    private static ChangeListener createJSlider(JSlider slider, GLJPanel gljPanel, Renderer renderer){
        return new JSliderXController(slider, gljPanel, renderer);
    }
}
