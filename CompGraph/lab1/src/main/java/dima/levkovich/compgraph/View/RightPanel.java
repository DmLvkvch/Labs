package dima.levkovich.compgraph.View;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Controller.*;
import dima.levkovich.compgraph.Model.Alpha;
import dima.levkovich.compgraph.Model.Blend;
import dima.levkovich.compgraph.Model.Primitives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
@Component
public class RightPanel extends JPanel {

    private JComboBox<String> comboBoxWithPrimitives;
    private JSlider sliderX;
    private  JSlider sliderY;
    private JComboBox<String> jComboBoxAlpha;
    private JSlider sliderAlpha;
    private JComboBox<String> jComboBoxSfactor;
    private JComboBox<String> jComboBoxDfactor;
    @Autowired
    @Lazy
    public RightPanel(GLJPanel gljPanel, Renderer renderer){
        comboBoxWithPrimitives = new JComboBox<>(Primitives.getPrimitives());
        this.setPreferredSize(new Dimension(230,700));
        setBackground(Color.blue);
        comboBoxWithPrimitives.addItemListener(new JComboBoxWithPrimitivesController(gljPanel, renderer));
        add(comboBoxWithPrimitives);
        sliderX = new JSlider(0, 600, 0);
        sliderX.addChangeListener(new JSliderXController(sliderX, gljPanel, renderer));
        add(sliderX);
        sliderY = new JSlider(0, 600, 0);
        sliderY.addChangeListener(new JSliderYController(sliderY, gljPanel, renderer));
        add(sliderY);
        jComboBoxAlpha = new JComboBox<>(Alpha.getAlpha());
        jComboBoxAlpha.addItemListener(new JComboBoxWithAlphaController(gljPanel, renderer));
        add(jComboBoxAlpha);
        sliderAlpha = new JSlider(0, 100, 0);
        sliderAlpha.addChangeListener(new JSliderAlpha(sliderAlpha, gljPanel, renderer));
        add(sliderAlpha);

        jComboBoxSfactor = new JComboBox<>(Blend.getSfactor());
        jComboBoxSfactor.addItemListener(new JComboBoxSFactor(gljPanel, renderer));
        add(jComboBoxSfactor);

        jComboBoxDfactor = new JComboBox<>(Blend.getDfactor());
        jComboBoxDfactor.addItemListener(new JComboBoxDFactor(gljPanel, renderer));
        add(jComboBoxDfactor);
    }

}
