package ru.bellintegrator.practice.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.model.Organization;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager em;

    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }
    @Transactional
    public List<Organization> getByName(String name, Long inn, boolean IsActive) {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = cb.createQuery(Organization.class);
        Root<Organization> organizationNameRoot = criteriaQuery.from(Organization.class);
        //TODO Ты проверял? Это работает?
        criteriaQuery.select(cb.construct(Organization.class,organizationNameRoot.get("id"),
                organizationNameRoot.get("name"),
                organizationNameRoot.get("is_Active")));
        criteriaQuery.where(cb.equal(organizationNameRoot.get("name"),name));
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    @Transactional
    public Organization getById(String uuid) {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = cb.createQuery(Object[].class);
        Root<Organization> organizationIdRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(cb.array(organizationIdRoot.get("uuid"), organizationIdRoot.get("name"),
                organizationIdRoot.get("full_Name"), organizationIdRoot.get("inn"), organizationIdRoot.get("kpp"),
                organizationIdRoot.get("address"),organizationIdRoot.get("phone"),
                organizationIdRoot.get("is_Active")));
        criteriaQuery.where(cb.equal(organizationIdRoot.get("uuid"),uuid));
        return (Organization) em.createQuery(criteriaQuery).getResultList();


    }

    @Override
    @Transactional
    public void update(Organization organization) {
        em.merge(organization);
    }
}
