/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.persistencia.dao.hibernate;

import com.nirsa.comprobantes.excepciones.DataAccessLayerException;
import com.nirsa.comprobantes.persistencia.bean.Emisor;
import com.nirsa.comprobantes.persistencia.dao.AbstractDao;
import com.nirsa.comprobantes.util.persistencia.HibernateFactory;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Rolando
 */
public class EmisorDaoHibernate extends AbstractDao {

    public EmisorDaoHibernate() {
        super();
    }

    /**
     * Insert a new Event into the database.
     * @param event
     */
    public void save(Emisor emisor) throws DataAccessLayerException {
        super.save(emisor);
    }
    
    /**
     * Updates a new Event into the database.
     * @param event
     */
    public void update(Emisor emisor) throws DataAccessLayerException {
        super.update(emisor);
    }

    /**
     * Delete a detached Event from the database.
     * @param event
     */
    public void delete(Emisor emisor) throws DataAccessLayerException {
        super.delete(emisor);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Emisor find(Long id) throws DataAccessLayerException {
        return (Emisor) super.find(Emisor.class, id);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Emisor.class);
    }

    public List<Emisor> findAllAvailables() {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from Emisor where emisorEstaActivo='Y'");
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
