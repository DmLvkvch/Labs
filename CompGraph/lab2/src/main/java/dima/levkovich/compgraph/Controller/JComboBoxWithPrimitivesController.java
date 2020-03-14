package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Model.Primitives;
import dima.levkovich.compgraph.View.Renderer;

import java.awt.event.ItemEvent;


public class JComboBoxWithPrimitivesController extends AbstractComboBox {

    public JComboBoxWithPrimitivesController(GLJPanel gljPanel, Renderer renderer){
        super(gljPanel, renderer);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String item = (String)e.getItem();
            // gljPanel.removeGLEventListener(renderer);
            renderer.setGLCode(Primitives.getCodeOfPrimitive(item));
            //gljPanel.addGLEventListener(renderer);
            gljPanel.repaint();

        }
    }

}
