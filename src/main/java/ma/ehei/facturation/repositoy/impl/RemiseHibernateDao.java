package ma.ehei.facturation.repositoy.impl;

import ma.ehei.facturation.model.Remise;
import ma.ehei.facturation.repositoy.RemiseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RemiseHibernateDao implements RemiseRepository {

    private final SessionFactory sessionFactory;
    public  RemiseHibernateDao(SessionFactory sf){
        this.sessionFactory=sf;
    }

    @Override
    public Remise findByBetweenMinAndMax(double max) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Remise r WHERE r.min <= :max AND (r.max >= :max OR r.max IS NULL)";
        return session.createQuery(hql, Remise.class)
                .setParameter("max", max)
                .uniqueResult();
    }
    @Override
    public Remise save(Remise remise) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(remise);
        return remise;
    }

    @Override
    public Remise update(Remise remise) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(remise);
        return remise;
    }

    @Override
    public void delete(Remise remise) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(remise);
    }
}
