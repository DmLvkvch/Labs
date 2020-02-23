package dima.levkovich.compgraph;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Model.Run;
import dima.levkovich.compgraph.View.MainWindow;
import dima.levkovich.compgraph.View.Renderer;
import dima.levkovich.compgraph.View.RightPanel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
@ComponentScan("dima.levkovich.compgraph")
public class Config {
    @Bean
    public JFrame mainWindow(){
        return new MainWindow(gljPanel(), renderer(), rightPanel(), panel());
    }
    @Bean
    public Thread run(){
        return new Run();
    }
    @Bean
    public Renderer renderer(){
        return new Renderer();
    }
    @Bean
    public GLJPanel gljPanel(){
        final GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        return new GLJPanel(glCapabilities);
    }
    @Bean
    public JPanel rightPanel(){
        return new RightPanel(gljPanel(), renderer());
    }

    @Bean JPanel panel(){
        return new dima.levkovich.compgraph.View.Panel(gljPanel());
    }
}
