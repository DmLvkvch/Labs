package dima.levkovich.compgraph;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Controller.*;
import dima.levkovich.compgraph.Model.Run;
import dima.levkovich.compgraph.View.MainWindow;
import dima.levkovich.compgraph.View.Renderer;
import dima.levkovich.compgraph.View.RightPanel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@ComponentScan("dima.levkovich.compgraph")
public class Config {
    @Bean
    public JFrame mainWindow(){
        return new MainWindow(rightPanel(), panel());
    }
    @Bean
    public Thread run(){

        return new Run();
    }

    @Bean
    public Renderer renderer() {
        return new Renderer();
    }

    @Bean
    public GLJPanel gljPanel(){
        final GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        GLJPanel gljPanel = new GLJPanel(glCapabilities);
        gljPanel.addGLEventListener(renderer());
        return gljPanel;
    }

    @Bean
    public JPanel rightPanel(){
        return new RightPanel(controllerFactory());
    }

    @Bean
    public JPanel panel(){
        JPanel jPanel = new dima.levkovich.compgraph.View.Panel(gljPanel());
       // new Thread((Runnable)jPanel).start();
        return jPanel;
    }

    @Bean
    public AbstractComboBox getDFactor(){
        return new JComboBoxDFactor(gljPanel(), renderer());
    }

    @Bean
    public AbstractComboBox getSFactor(){
        return new JComboBoxSFactor(gljPanel(), renderer());
    }

    @Bean
    public AbstractComboBox getAlpha(){
        return new JComboBoxWithAlphaController(gljPanel(), renderer());
    }

    @Bean
    public AbstractComboBox getPrimitives(){
        return new JComboBoxWithPrimitivesController(gljPanel(), renderer());
    }

    @Bean
    ControllerFactory controllerFactory(){
        return new ControllerFactory(gljPanel(), renderer());
    }
}
