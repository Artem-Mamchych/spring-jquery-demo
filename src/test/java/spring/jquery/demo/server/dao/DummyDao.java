package spring.jquery.demo.server.dao;

import spring.jquery.demo.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link spring.jquery.demo.server.dao.impl.GenericHibernateDaoImpl} methods
 */
public interface DummyDao extends GenericDao<DummyEntity, Long> {
}
