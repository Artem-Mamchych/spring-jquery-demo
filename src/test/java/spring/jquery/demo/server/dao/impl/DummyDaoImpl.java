package spring.jquery.demo.server.dao.impl;

import org.springframework.stereotype.Repository;

import spring.jquery.demo.server.dao.DummyDao;
import spring.jquery.demo.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link GenericHibernateDaoImpl} methods
 */
@Repository
public class DummyDaoImpl
        extends GenericHibernateDaoImpl<DummyEntity, Long>
        implements DummyDao {
}
