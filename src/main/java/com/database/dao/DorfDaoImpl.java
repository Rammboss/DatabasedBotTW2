package com.database.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.database.model.Dorf;

@Repository("dorfDao")
public class DorfDaoImpl extends AbstractDao implements DorfDao {

	@Override
	public void saveDorf(Dorf dorf) {
		persist(dorf);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dorf> findbyName(String name) {
		Criteria criteria = getSession().createCriteria(Dorf.class);

		return criteria.add(Restrictions.like("name", name)).list();
	}

	@Override
	public void updateDorf(Dorf dorf) {
		getSession().update(dorf);

	}

}
