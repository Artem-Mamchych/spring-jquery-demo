package spring.jquery.demo.server.dao;

import spring.jquery.demo.server.entity.Persistent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HashMapDao<T, ID> {

    Map<ID, T> map = new HashMap<ID, T>();

    T findById(ID id, boolean lock) {
        return map.get(id);
    }

    List<T> findAll() {
        return (List<T>) map.values();
    }

    abstract List<T> findByExample(T exampleInstance, String[] excludeProperty);

    abstract T makePersistent(T entity);

    abstract void makeTransient(T entity);
}
