package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.View.Renderer;

public class ControllerFactory {
    protected GLJPanel gljPanel;
    protected Renderer renderer;

    public ControllerFactory(GLJPanel gljPanel, Renderer renderer){
        this.gljPanel = gljPanel;
        this.renderer = renderer;
    }

    public ControllerFactory getInstance(String string){
        if(string=="Slider"){
            return new SliderFactory(gljPanel, renderer);
        }
        if(string=="ComboBox"){
            return new ComboBoxFactory(gljPanel, renderer);
        }
        return null;
    }

}
