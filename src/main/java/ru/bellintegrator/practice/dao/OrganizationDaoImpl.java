package ru.bellintegrator.practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }
    @Transactional
    public List<Organization> getOrganizations(String name, Long inn, boolean IsActive) {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = cb.createQuery(Organization.class);
        Root<Organization> organizationNameRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(cb.construct(Organization.class,organizationNameRoot.get("id"),
                organizationNameRoot.get("name"),
                organizationNameRoot.get("is_Active")));
        criteriaQuery.where(cb.equal(organizationNameRoot.get("name"),name));
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    @Transactional
    public Organization getOrganization(Long id) {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = cb.createQuery(Object[].class);
        Root<Organization> organizationIdRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(cb.array(organizationIdRoot.get("id"), organizationIdRoot.get("name"),
                organizationIdRoot.get("full_Name"), organizationIdRoot.get("inn"), organizationIdRoot.get("kpp"),
                organizationIdRoot.get("address"),organizationIdRoot.get("phone"),
                organizationIdRoot.get("is_Active")));
        criteriaQuery.where(cb.equal(organizationIdRoot.get("id"),id));
        return (Organization) em.createQuery(criteriaQuery).getResultList();


    }

    @Override
    @Transactional
    public void updateOrganization(Organization organization) {
        em.getTransaction().begin();
        em.merge(organization);
        em.getTransaction().commit();

    }
}
