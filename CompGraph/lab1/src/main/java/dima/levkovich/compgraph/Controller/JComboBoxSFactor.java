package dima.levkovich.compgraph.Controller;
import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Model.Alpha;
import dima.levkovich.compgraph.Model.Blend;
import dima.levkovich.compgraph.View.Renderer;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JComboBoxSFactor implements ItemListener {
    private GLJPanel gljPanel;
    private Renderer renderer;

    public JComboBoxSFactor(GLJPanel gljPanel, Renderer renderer){
        this.gljPanel = gljPanel;
        this.renderer = renderer;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String item = (String)e.getItem();
            // gljPanel.removeGLEventListener(renderer);
            renderer.setSfactor(Blend.getCodeOfSfactor(item));
            //gljPanel.addGLEventListener(renderer);
            gljPanel.repaint();

        }
    }
}