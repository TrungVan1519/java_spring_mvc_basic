package com.example.dao.impl;  

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ProductDAO;
import com.example.entity.ProductEntity;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void add(ProductEntity productEntity) {
		
		sessionFactory.getCurrentSession().save(productEntity);
	}

	public void update(ProductEntity productEntity) {
		
		sessionFactory.getCurrentSession().merge(productEntity);
	}

	public void deleteById(int id) {
		
		sessionFactory.getCurrentSession().delete(this.findById(id));
	}

	public ProductEntity findById(int id) {
		
		return sessionFactory.getCurrentSession().get(ProductEntity.class, id);
	}

	public List<ProductEntity> findAll() {
		
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<ProductEntity> criteriaQuery = builder.createQuery(ProductEntity.class);
        criteriaQuery.from(ProductEntity.class);

        List<ProductEntity> studentEntities = session.createQuery(criteriaQuery).getResultList();

        return studentEntities;
	}
}
