package ru.bellintegrator.practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OfficeDaoImpl implements OfficeDao{

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
       this.em = em;
   }

    @Override
    public List<Office> getAllOffices() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office getOfficeById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }



}
