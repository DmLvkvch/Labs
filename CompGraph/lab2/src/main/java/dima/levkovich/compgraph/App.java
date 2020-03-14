package dima.levkovich.compgraph;

import dima.levkovich.compgraph.Model.*;
import org.hibernate.Session;

public class App {
    public static void main( String[] args ){
       // Session session = HibernateSessionFactory.getSessionFactory().openSession();
       // session.beginTransaction();
       // PrimitivesDB primitivesDB = new PrimitivesDB();
       // System.out.println(Arrays.asList(session.createQuery("select () from PrimitivesDB primitive").getReturnAliases()));
        //list.forEach(System.out::println);
       // session.save(primitivesDB);
       // session.getTransaction().commit();
      //  session.close();
        Thread thread = new Run();
        thread.start();
    }
}
