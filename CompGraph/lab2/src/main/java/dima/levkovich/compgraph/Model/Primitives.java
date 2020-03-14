package dima.levkovich.compgraph.Model;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Primitives{
    private static String[] list;
    private static Map<String, Integer> map = new HashMap<>();

    static {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<PrimitivesDB> primitive_from_primitivesDB_primitives = session.createQuery("select primitive from PrimitivesDB primitive").list();
        list = Arrays.asList(primitive_from_primitivesDB_primitives.stream().map(PrimitivesDB::getName).toArray()).toArray(new String[1]);
        primitive_from_primitivesDB_primitives.forEach(s->map.put(s.getName(), s.getId()));
        session.getTransaction().commit();
        session.close();
    }

    public static String[] getPrimitives(){
        return list;
    }

    public static Integer getCodeOfPrimitive(String string){
        return map.get(string);
    }
}
