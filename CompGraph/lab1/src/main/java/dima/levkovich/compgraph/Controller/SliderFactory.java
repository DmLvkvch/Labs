package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Model.Alpha;
import dima.levkovich.compgraph.Model.Blend;
import dima.levkovich.compgraph.Model.Primitives;
import dima.levkovich.compgraph.View.Renderer;

import javax.swing.*;

public class SliderFactory extends ControllerFactory {

    public SliderFactory(GLJPanel gljPanel, Renderer renderer){
        super(gljPanel, renderer);
    }

    public JSlider getInstanceOfSlider(String id){
        JSlider jSlider;
        switch (id){
            case "X":
                jSlider = new JSlider(0, 600, 0);
                jSlider.addChangeListener(new JSliderXController(jSlider, gljPanel, renderer));
                break;
            case  "Y":
                jSlider = new JSlider(0, 600, 0);
                jSlider.addChangeListener(new JSliderYController(jSlider, gljPanel, renderer));
                break;
            case  "Alpha":
                jSlider = new JSlider(0, 100, 0);
                jSlider.addChangeListener(new JSliderAlpha(jSlider, gljPanel, renderer));
                break;
            default:
                jSlider = null;
        }
        return jSlider;
    }
}
