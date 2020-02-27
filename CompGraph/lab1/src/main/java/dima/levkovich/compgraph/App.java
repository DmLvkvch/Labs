package dima.levkovich.compgraph;

import dima.levkovich.compgraph.Model.Run;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Thread thread = context.getBean("run", Run.class);
        thread.start();
    }
}
