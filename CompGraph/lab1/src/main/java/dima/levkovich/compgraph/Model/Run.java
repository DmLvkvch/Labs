package dima.levkovich.compgraph.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
public class Run extends Thread{
    @Autowired
    private JFrame mainWindow;
    public Run(){
    }
    @Override
    public void run() {
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}

