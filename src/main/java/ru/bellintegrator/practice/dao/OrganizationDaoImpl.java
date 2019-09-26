package ru.bellintegrator.practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> getAllOrganizations() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public void saveOrganization(Organization organization) {
        em.persist(organization);
    }
}
