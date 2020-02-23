package dima.levkovich.compgraph.View;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Config;
import dima.levkovich.compgraph.View.Panel;
import dima.levkovich.compgraph.View.RightPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
@Component
public class MainWindow extends JFrame {
    @Autowired
    public MainWindow(GLJPanel gljPanel, Renderer renderer, JPanel rightPanel, JPanel panel){
        super("Levkovich Dmitry");
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        gljPanel.addGLEventListener(renderer);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridy   = 0  ;
        setSize(900, 600);
        constraints.gridx = 0;
        contentPanel.add(panel, constraints);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        constraints.gridx = 1;      // первая ячейка таблицы по горизонтали
        constraints.gridy = 0;
        constraints.gridheight = 2;
        contentPanel.add(rightPanel, constraints);
        add(contentPanel);
    }
}
