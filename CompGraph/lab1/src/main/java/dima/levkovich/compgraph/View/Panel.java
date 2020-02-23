package dima.levkovich.compgraph.View;
import com.jogamp.opengl.awt.GLJPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
@Component
public class Panel extends JPanel {
    @Autowired
    @Lazy
    public Panel(GLJPanel gljPanel){
        setPreferredSize(new Dimension(600, 600));
        gljPanel.setPreferredSize(new Dimension(600, 600));
        add(gljPanel);
        setBackground(Color.red);
    }
}
