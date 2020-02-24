package dima.levkovich.compgraph.View;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
@Component
public class RightPanel extends JPanel {

    private JComboBox<String> comboBoxWithPrimitives;
    private JSlider sliderX;
    private  JSlider sliderY;
    private JComboBox<String> jComboBoxAlpha;
    private JSlider sliderAlpha;
    private JComboBox<String> jComboBoxSfactor;
    private JComboBox<String> jComboBoxDfactor;
    private ControllerFactory controllerFactory;
    @Autowired
    public RightPanel(GLJPanel gljPanel, Renderer renderer, ControllerFactory controllerFactory){
        ComboBoxFactory comboBoxFactory =(ComboBoxFactory)controllerFactory.getInstance("ComboBox");
        SliderFactory sliderFactory = (SliderFactory)controllerFactory.getInstance("Slider");
        comboBoxWithPrimitives = comboBoxFactory.getInstanceOfCombo("Primitives");
        this.setPreferredSize(new Dimension(230,700));
        setBackground(Color.blue);
        //comboBoxWithPrimitives.addItemListener(new JComboBoxWithPrimitivesController(gljPanel, renderer));
        add(comboBoxWithPrimitives);
        sliderX = sliderFactory.getInstanceOfSlider("X");
       // sliderX.addChangeListener(new JSliderXController(sliderX, gljPanel, renderer));
        add(sliderX);
        sliderY = sliderFactory.getInstanceOfSlider("Y");
       // sliderY.addChangeListener(new JSliderYController(sliderY, gljPanel, renderer));
        add(sliderY);
        jComboBoxAlpha = comboBoxFactory.getInstanceOfCombo("Alpha");
     //   jComboBoxAlpha.addItemListener(new JComboBoxWithAlphaController(gljPanel, renderer));
        add(jComboBoxAlpha);
        sliderAlpha = sliderFactory.getInstanceOfSlider("Alpha");
       // sliderAlpha.addChangeListener(new JSliderAlpha(sliderAlpha, gljPanel, renderer));
        add(sliderAlpha);

        jComboBoxSfactor = comboBoxFactory.getInstanceOfCombo("SFactor");
       // jComboBoxSfactor.addItemListener(new JComboBoxSFactor(gljPanel, renderer));
        add(jComboBoxSfactor);

        jComboBoxDfactor = comboBoxFactory.getInstanceOfCombo("DFactor");
     //   jComboBoxDfactor.addItemListener(new JComboBoxDFactor(gljPanel, renderer));
        add(jComboBoxDfactor);
    }

}
