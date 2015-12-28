/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.jsf.bean;

import com.nirsa.comprobantes.persistencia.bean.Rol;
import com.nirsa.comprobantes.persistencia.dao.hibernate.RolDaoHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rolando
 */
@ManagedBean
@ViewScoped
public class RolMB implements Serializable {

    private String codigo;
    private String descripcion;
    private Date fechaCreacion;
    private List<Rol> listaRoles;
    private Rol rolSeleccionado;
//    private TablaRol rolEditado;

    /** Creates a new instance of RolMB */
    public RolMB() {
        obtenerListaRoles();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public void editarRol() {
        System.out.println(rolSeleccionado.getId() + "\t" + rolSeleccionado.getRolCodigo() + "\t" + rolSeleccionado.getRolDescripcion());
        RolDaoHibernate dao = new RolDaoHibernate();
        dao.update(rolSeleccionado);
    }

    public void guardarRol() {
        Rol rol = new Rol();
        rol.setRolCodigo(codigo);
        rol.setRolDescripcion(descripcion);
        rol.setRolFechaActualizacion(new Date());
        rol.setRolFechaCreacion(new Date());
        rol.setRolEstaActivo('Y');
        RolDaoHibernate dao = new RolDaoHibernate();
        dao.save(rol);
    }

    public void eliminarRol() {
        RolDaoHibernate dao = new RolDaoHibernate();
        if (rolSeleccionado != null) {
            rolSeleccionado.setRolEstaActivo('N');
            dao.update(rolSeleccionado);
        }
        obtenerListaRoles();
    }

    private void obtenerListaRoles() {
        RolDaoHibernate dao = new RolDaoHibernate();
        listaRoles = new ArrayList<Rol>();
        listaRoles = dao.findAllAvailables();
    }
}
