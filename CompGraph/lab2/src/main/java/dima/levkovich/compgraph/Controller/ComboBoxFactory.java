package dima.levkovich.compgraph.Controller;

import com.jogamp.opengl.awt.GLJPanel;
import dima.levkovich.compgraph.Model.Alpha;
import dima.levkovich.compgraph.Model.Blend;
import dima.levkovich.compgraph.Model.Primitives;
import dima.levkovich.compgraph.View.Renderer;

import javax.swing.*;

public class ComboBoxFactory extends ControllerFactory{

    public ComboBoxFactory(GLJPanel gljPanel, Renderer renderer){
        super(gljPanel, renderer);
    }

    public JComboBox getInstanceOfCombo(String id){
        JComboBox<String> jComboBox;
        switch (id){
            case "DFactor":
                jComboBox = new JComboBox(Blend.getDfactor());
                jComboBox.addItemListener(new JComboBoxDFactor(gljPanel, renderer));
                return jComboBox;
            case  "SFactor":
                jComboBox = new JComboBox(Blend.getSfactor());
                jComboBox.addItemListener(new JComboBoxSFactor(gljPanel, renderer));
                return jComboBox;
            case  "Alpha":
                jComboBox = new JComboBox(Alpha.getAlpha());
                jComboBox.addItemListener(new JComboBoxWithAlphaController(gljPanel, renderer));
                return jComboBox;
            case  "Primitives":
                jComboBox = new JComboBox(Primitives.getPrimitives());
                jComboBox.addItemListener(new JComboBoxWithPrimitivesController(gljPanel, renderer));
                return jComboBox;
            default:
                 return null;
        }
    }
}
