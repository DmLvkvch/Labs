package dima.levkovich.compgraph.Model;

import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alpha {
    private static String[] list;
    private static Map<String, Integer> map = new HashMap<>();

    static {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<AlphaDB> alphas = session.createQuery("select alpha from AlphaDB alpha").list();
        list = Arrays.asList(alphas.stream().map(AlphaDB::getAlpha).toArray()).toArray(new String[1]);
        alphas.forEach(s->map.put(s.getAlpha(), s.getAlphaid()));
        session.getTransaction().commit();
        session.close();
    }

    public static String[] getAlpha() {
        return list;
    }


    public static Integer getCodeOfAlpha(String string){
        return map.get(string);
    }
}
