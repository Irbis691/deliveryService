package com.preproduction.delivery.locator;

/**
 * Created by Mantixop on 1/22/16.
 */
public interface Config {
    public <T> Class<T> getImpl(String ifc);
}
