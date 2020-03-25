package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.View.Renderer;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public abstract class AbstractSlider implements ChangeListener {
    protected GLJPanel gljPanel;
    protected Renderer renderer;
    protected JSlider jSlider;

    public AbstractSlider(GLJPanel gljPanel, Renderer renderer, JSlider jSlider) {
        this.gljPanel = gljPanel;
        this.renderer = renderer;
        this.jSlider = jSlider;
    }
}
