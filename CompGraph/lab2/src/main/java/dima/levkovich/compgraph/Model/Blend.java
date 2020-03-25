package dima.levkovich.compgraph.Model;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blend {
    private static String[] sfactor;
    private static String[] dfactor;
    private static Map<String, Integer> sfactorMap = new HashMap<>();
    private static Map<String, Integer> dfactorMap = new HashMap<>();
    static {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<SFactorDB> list = session.createQuery("select sfactor from SFactorDB sfactor").list();
        sfactor = Arrays.asList(list.stream().map(SFactorDB::getSfactor).toArray()).toArray(new String[1]);
        list.forEach(s->sfactorMap.put(s.getSfactor(), s.getSfactorid()));

        List<DFactorDB> list_ = session.createQuery("select dfactor from DFactorDB dfactor").list();
        dfactor = Arrays.asList(list_.stream().map(DFactorDB::getDfactor).toArray()).toArray(new String[1]);
        list_.forEach(s->dfactorMap.put(s.getDfactor(), s.getDfactorid()));
        session.getTransaction().commit();
        session.close();
    }

    public static String[] getSfactor() {
        return sfactor;
    }

    public static String[] getDfactor() {
        return dfactor;
    }

    public static Integer getCodeOfSfactor(String string){
        return sfactorMap.get(string);
    }

    public static Integer getCodeOfDfactor(String string){
        return dfactorMap.get(string);
}
}
