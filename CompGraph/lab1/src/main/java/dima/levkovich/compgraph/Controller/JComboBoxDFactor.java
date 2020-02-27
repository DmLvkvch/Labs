package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Model.Blend;
import dima.levkovich.compgraph.View.Renderer;
import java.awt.event.ItemEvent;

public class JComboBoxDFactor extends AbstractComboBox {

    public JComboBoxDFactor(GLJPanel gljPanel, Renderer renderer){
        super(gljPanel, renderer);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String item = (String)e.getItem();
            // gljPanel.removeGLEventListener(renderer);
            renderer.setDfactor(Blend.getCodeOfDfactor(item));
            //gljPanel.addGLEventListener(renderer);
            gljPanel.repaint();

        }
    }
}
