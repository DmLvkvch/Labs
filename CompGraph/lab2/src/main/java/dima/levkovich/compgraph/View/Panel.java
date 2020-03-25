package dima.levkovich.compgraph.View;
import com.jogamp.opengl.awt.GLJPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
@Component
public class Panel extends JPanel implements Runnable{
    private GLJPanel gljPanel;
    private boolean flag = true;
    @Autowired
    public Panel(GLJPanel gljPanel){
        this.gljPanel = gljPanel;
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.red);
        gljPanel.setPreferredSize(new Dimension(600, 600));
        add(gljPanel);
    }

    @Override
    public void run() {
    }
}
