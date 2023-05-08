package main.java.com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;

public abstract class AbstractRepository<T extends Serializable> {
    /**
     * C-create
     * R-read
     * U-update
     * D-delete
     */

    private Class<T> entityClass;
    private EntityManager em;

    public AbstractRepository(EntityManager entityManager, Class<T> entityClass) {
        this.em = entityManager;
        this.entityClass = entityClass;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity){
        em.persist(entity);
    }

    public  T findById(int id){
        return em.find(entityClass, id);
    }

    public  T update(T entity){
        return em.merge(entity);
    }

    public  void delete(T entity){
        em.remove(entity);
    }

    //The em.find() method expects the second parameter to be of the same type as
    // the entity's primary key. In your case, it appears that the primary key of your
    // entity is of type Integer, but you are passing a String (name) as the second argument.
    public boolean exists(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<T> root = query.from(entityClass);
        query.select(cb.count(root));
        query.where(cb.equal(root.get("name"), name));
        Long count = em.createQuery(query).getSingleResult();
        return count > 0;
    }

    public boolean existsTitle(String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<T> root = query.from(entityClass);
        query.select(cb.count(root));
        query.where(cb.equal(root.get("title"), title));
        Long count = em.createQuery(query).getSingleResult();
        return count > 0;
    }


    public T findByName(String name) {
        //return em.find(entityClass, name);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        query.select(root);
        query.where(cb.equal(root.get("name"), name));
        return em.createQuery(query).getSingleResult();

    }

    public T findByTitle(String title) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        query.select(root);
        query.where(cb.equal(root.get("title"), title));
        return em.createQuery(query).getSingleResult();
    }
}
