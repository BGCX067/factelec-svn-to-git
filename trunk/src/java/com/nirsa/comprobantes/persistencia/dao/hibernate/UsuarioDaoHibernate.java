/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.persistencia.dao.hibernate;

import com.nirsa.comprobantes.excepciones.DataAccessLayerException;
import com.nirsa.comprobantes.persistencia.bean.Usuario;
import com.nirsa.comprobantes.persistencia.dao.AbstractDao;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class UsuarioDaoHibernate extends AbstractDao {

    public UsuarioDaoHibernate() {
        super();
    }

    /**
     * Insert a new Event into the database.
     * @param event
     */
    public void save(Usuario usuario) throws DataAccessLayerException {
        super.save(usuario);
    }

    /**
     * Updates a new Event into the database.
     * @param event
     */
    public void update(Usuario usuario) throws DataAccessLayerException {
        super.update(usuario);
    }

    /**
     * Delete a detached Event from the database.
     * @param event
     */
    public void delete(Usuario usuario) throws DataAccessLayerException {
        super.delete(usuario);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Usuario find(Long id) throws DataAccessLayerException {
        return (Usuario) super.find(Usuario.class, id);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Usuario.class);
    }
}
