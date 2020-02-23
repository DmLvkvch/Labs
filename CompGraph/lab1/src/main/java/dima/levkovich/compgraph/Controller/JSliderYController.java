package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.View.Renderer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderYController implements ChangeListener {
    private GLJPanel gljPanel;
    private Renderer renderer;
    private JSlider jSlider;

    public JSliderYController(JSlider jSlider, GLJPanel gljPanel, Renderer renderer){
        this.gljPanel = gljPanel;
        this.renderer = renderer;
        this.jSlider = jSlider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int value;
        value = 600 - jSlider.getValue();
        renderer.setScissor_y(value);
        gljPanel.repaint();
    }
}
