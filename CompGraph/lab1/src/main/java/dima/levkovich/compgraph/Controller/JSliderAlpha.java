package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.View.Renderer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class JSliderAlpha extends AbstractSlider{

    public JSliderAlpha(JSlider jSlider, GLJPanel gljPanel, Renderer renderer){
        super(gljPanel, renderer, jSlider);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        float value = (float)jSlider.getValue()/100;
        //System.out.println(value);
        renderer.setAlphaParam(value);

        gljPanel.repaint();
    }
}
