package spring.jquery.demo.server.dao.impl;

import org.junit.Test;
import spring.jquery.demo.ApplicationContextAwareTest;
import spring.jquery.demo.server.dao.DummyDao;
import spring.jquery.demo.server.entity.DummyEntity;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * 
 */
public class SimpleIntegrationTest extends ApplicationContextAwareTest {

    @Resource
    private DummyDao dummyDAO;

    /**
     * Tries to store {@link spring.jquery.demo.server.entity.DummyEntity}.
     */
    @Test
    public void testPersistTestEntity() {
        int countBefore = dummyDAO.findAll().size();
        DummyEntity dummyEntity = new DummyEntity();
        dummyDAO.makePersistent(dummyEntity);

        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore + 1, countAfter);
    }
}
