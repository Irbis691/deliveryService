package com.preproduction.delivery.infrastructure;

/**
 *
 * @author Irbis
 */
public interface Config {
    public <T> Class<T> getImpl(String ifc);
}
