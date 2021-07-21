package com.codegym.model.repository.impl;
import com.codegym.model.bean.Product;
import com.codegym.model.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return BaseRepository.entityManager.createQuery("SELECT s FROM product s", Product.class).getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select s " +
                "from product s where s.name=?1", Product.class);
        typedQuery.setParameter(1, name);
        return typedQuery.getResultList();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();

       //Cách 2:
       /* Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product origin = findById(product.getId());
            origin.setName(product.getName());
            origin.setPrice(product.getPrice());
            origin.setDescribeProduct(product.getDescribeProduct());
            origin.setProducer(product.getProducer());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }*/
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        transaction.commit();

        //Cách 2:
        /*Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }*/
    }


    @Override
    public Product findById(int id) {
       /* TypedQuery<Product> typedQuery =BaseRepository.entityManager.createQuery("select s " +
                "from product s where s.id=?1",Product.class);
        typedQuery.setParameter(1,id);
        return typedQuery.getSingleResult();*/
        return BaseRepository.entityManager.find(Product.class,id);
    }
}
