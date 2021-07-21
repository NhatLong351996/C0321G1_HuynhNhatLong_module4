package com.codegym.model.repository.impl;
import com.codegym.model.bean.Product;
import com.codegym.model.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
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
       /* Cách này e thử nhưng ko dc, */
        /*EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("update product set " +
                "product .name=?1,product .describeProduct=?2,product .price=?3,product .producer=?4 where product .id=?5", Product.class);
        typedQuery.setParameter(1, product.getName());
        typedQuery.setParameter(2, product.getDescribeProduct());
        typedQuery.setParameter(3, product.getPrice());
        typedQuery.setParameter(4, product.getProducer());
        typedQuery.setParameter(5, id);
        transaction.commit();*/

        Session session = null;
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
        }
    }

    @Override
    public void remove(int id) {
        //Cách này e thử nhưng ko dc//
      /*  EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        TypedQuery query = BaseRepository.entityManager.createQuery("delete from product  " +
                "where product.id=?1", Product.class);
        query.setParameter(1, id);
        transaction.commit();*/

        Session session = null;
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
        }
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
