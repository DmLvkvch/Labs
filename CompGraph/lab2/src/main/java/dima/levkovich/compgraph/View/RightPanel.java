package dima.levkovich.compgraph.View;

import dima.levkovich.compgraph.Controller.ComboBoxFactory;
import dima.levkovich.compgraph.Controller.ControllerFactory;
import dima.levkovich.compgraph.Controller.SliderFactory;
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
    private JSlider sliderFractal;
    @Autowired
    public RightPanel(ControllerFactory controllerFactory){
        ComboBoxFactory comboBoxFactory =(ComboBoxFactory)controllerFactory.getInstance("ComboBox");
        SliderFactory sliderFactory = (SliderFactory)controllerFactory.getInstance("Slider");
        comboBoxWithPrimitives = comboBoxFactory.getInstanceOfCombo("Primitives");
        this.setPreferredSize(new Dimension(230,700));
        setBackground(Color.blue);
        add(comboBoxWithPrimitives);
        sliderX = sliderFactory.getInstanceOfSlider("X");
        add(sliderX);
        sliderY = sliderFactory.getInstanceOfSlider("Y");
        add(sliderY);
        sliderFractal = sliderFactory.getInstanceOfSlider("Fractal");
        add(sliderFractal);
        jComboBoxAlpha = comboBoxFactory.getInstanceOfCombo("Alpha");
        add(jComboBoxAlpha);
        sliderAlpha = sliderFactory.getInstanceOfSlider("Alpha");
        add(sliderAlpha);
        jComboBoxSfactor = comboBoxFactory.getInstanceOfCombo("SFactor");
        add(jComboBoxSfactor);
        jComboBoxDfactor = comboBoxFactory.getInstanceOfCombo("DFactor");
        add(jComboBoxDfactor);
    }

}
