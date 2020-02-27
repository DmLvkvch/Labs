package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.View.Renderer;
import java.awt.event.ItemListener;

public abstract class AbstractComboBox implements ItemListener {
    protected GLJPanel gljPanel;
    protected Renderer renderer;
    public AbstractComboBox(GLJPanel gljPanel, Renderer renderer){
        this.gljPanel = gljPanel;
        this.renderer = renderer;
    }
}
