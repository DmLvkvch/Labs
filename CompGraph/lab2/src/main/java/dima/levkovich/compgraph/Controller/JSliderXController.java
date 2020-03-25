package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.View.Renderer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class JSliderXController extends AbstractSlider {

    public JSliderXController(JSlider jSlider, GLJPanel gljPanel, Renderer renderer){
        super(gljPanel, renderer, jSlider);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int value;
        value = 600 - jSlider.getValue();
        renderer.setScissor_x(value);
        gljPanel.repaint();
    }
}
