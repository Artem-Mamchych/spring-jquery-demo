package spring.jquery.demo.server.entity;

/**
 * Basic interface for persistent objects.
 */
public interface Persistent {

    /**
     * Get the primary id of the persistent object.
     *
     * @return the id
     */
    public Long getId();

    /**
     * Set the id for the persistent object.
     *
     * @param id id to set
     */
    public void setId(Long id);
}
