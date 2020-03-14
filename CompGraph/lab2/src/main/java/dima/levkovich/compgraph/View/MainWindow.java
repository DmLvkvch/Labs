package dima.levkovich.compgraph.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainWindow extends JFrame {
    @Autowired
    public MainWindow(JPanel rightPanel, JPanel panel){
        super("Levkovich Dmitry");
       // Thread.getAllStackTraces().keySet().forEach((t) -> System.out.println(t.getName() + "\nIs Daemon " + t.isDaemon() + "\nIs Alive " + t.isAlive()));
/*        System.out.println(Thread.currentThread().getName()+" MainWindow");
        System.out.println(Thread.currentThread().getId()+" MainWindow");*/
        JPanel contentPanel = new JPanel();
//        Thread thread = new Thread((Runnable)panel);
//      // // Arrays.stream(Thread.getAllStackTraces().keySet().toArray()).forEach(t->);
//     //   Thread.getAllStackTraces().keySet().forEach((t) -> System.out.println(!t.isDaemon() ? t.getName() + "\nIs Daemon " + t.isDaemon() + "\nIs Alive " + t.isAlive() : ""));
//      //  System.out.println();
//        thread.start();
       // System.out.println(thread.isAlive());
      //  Thread.getAllStackTraces().keySet().forEach((t) -> System.out.println(!t.isDaemon() ? t.getName() + "\nIs Daemon " + t.isDaemon() + "\nIs Alive " + t.isAlive() : ""));
        contentPanel.setLayout(new GridBagLayout());
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
