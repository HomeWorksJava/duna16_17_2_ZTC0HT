
package com.ticktacktoe.game.services;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * @author krisztian
 */
public interface GenericDaoService {
    
    public EntityManager getEM();
    public Object save(Object pSort);
    public List getEntities(String pQuery, Map<String, Object> pParams);

    public Object getEntity(String pQuery, Map<String, Object> pParams);
    
}
