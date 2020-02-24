package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Model.Alpha;
import dima.levkovich.compgraph.View.Renderer;
import java.awt.event.ItemEvent;

public class JComboBoxWithAlphaController extends AbstractComboBox{

        public JComboBoxWithAlphaController(GLJPanel gljPanel, Renderer renderer){
            super(gljPanel, renderer);
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String item = (String)e.getItem();
                // gljPanel.removeGLEventListener(renderer);
                renderer.setAlphaCode(Alpha.getCodeOfAlpha(item));
                //gljPanel.addGLEventListener(renderer);
                gljPanel.repaint();

            }
        }

}
