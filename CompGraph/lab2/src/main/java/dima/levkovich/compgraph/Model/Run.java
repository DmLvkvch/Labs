package dima.levkovich.compgraph.Model;
import dima.levkovich.compgraph.Config;
import dima.levkovich.compgraph.View.MainWindow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
@Scope("prototype")
public class Run extends Thread{

    public Run(){
        super("RUN");
    }

    @Override
    public void run() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        JFrame mainWindow = context.getBean("mainWindow", MainWindow.class);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}

