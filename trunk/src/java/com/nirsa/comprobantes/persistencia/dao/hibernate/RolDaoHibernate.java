/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.persistencia.dao.hibernate;

import com.nirsa.comprobantes.excepciones.DataAccessLayerException;
import com.nirsa.comprobantes.persistencia.bean.Rol;
import com.nirsa.comprobantes.persistencia.dao.AbstractDao;
import com.nirsa.comprobantes.util.persistencia.HibernateFactory;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Rolando
 */
public class RolDaoHibernate extends AbstractDao {

    public RolDaoHibernate() {
        super();
    }

    /**
     * Insert a new Event into the database.
     * @param event
     */
    public void save(Rol rol) throws DataAccessLayerException {
        super.save(rol);
    }
    
    /**
     * Updates a new Event into the database.
     * @param event
     */
    public void update(Rol rol) throws DataAccessLayerException {
        super.update(rol);
    }

    /**
     * Delete a detached Event from the database.
     * @param event
     */
    public void delete(Rol rol) throws DataAccessLayerException {
        super.delete(rol);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Rol find(Long id) throws DataAccessLayerException {
        return (Rol) super.find(Rol.class, id);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Rol.class);
    }

    public List<Rol> findAllAvailables() {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from Rol where rolEstaActivo='Y'");
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }
}
