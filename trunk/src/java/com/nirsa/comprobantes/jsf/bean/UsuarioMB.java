/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.jsf.bean;

import com.nirsa.comprobantes.persistencia.bean.Emisor;
import com.nirsa.comprobantes.persistencia.bean.Rol;
import com.nirsa.comprobantes.persistencia.dao.hibernate.EmisorDaoHibernate;
import com.nirsa.comprobantes.persistencia.dao.hibernate.RolDaoHibernate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rolando
 */
@ManagedBean
@ViewScoped
public class UsuarioMB {

    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String claveUsuario;
    private String claveUsuarioRepetida;
    private String correoElectrónico;
    private List<Rol> listaRoles;
    private List<Emisor> listaEmisores;
    private Rol rolSeleccionado;
    private Emisor emisorSeleccionado;

    /** Creates a new instance of UsuarioMB */
    public UsuarioMB() {
        obtenerListaRoles();
        obtenerListaEmisores();
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getClaveUsuarioRepetida() {
        return claveUsuarioRepetida;
    }

    public void setClaveUsuarioRepetida(String claveUsuarioRepetida) {
        this.claveUsuarioRepetida = claveUsuarioRepetida;
    }

    public String getCorreoElectrónico() {
        return correoElectrónico;
    }

    public void setCorreoElectrónico(String correoElectrónico) {
        this.correoElectrónico = correoElectrónico;
    }

    public Emisor getEmisorSeleccionado() {
        return emisorSeleccionado;
    }

    public void setEmisorSeleccionado(Emisor emisorSeleccionado) {
        this.emisorSeleccionado = emisorSeleccionado;
    }

    public List<Emisor> getListaEmisores() {
        return listaEmisores;
    }

    public void setListaEmisores(List<Emisor> listaEmisores) {
        this.listaEmisores = listaEmisores;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    private void obtenerListaRoles() {
        RolDaoHibernate dao = new RolDaoHibernate();
        listaRoles = new ArrayList<Rol>();
        listaRoles = dao.findAllAvailables();
        if (!listaRoles.isEmpty()) {
            rolSeleccionado = listaRoles.get(0);
        }
    }

    private void obtenerListaEmisores() {
        EmisorDaoHibernate dao = new EmisorDaoHibernate();
        listaEmisores = new ArrayList<Emisor>();
        listaEmisores = dao.findAllAvailables();
        if (!listaEmisores.isEmpty()) {
            emisorSeleccionado = listaEmisores.get(0);
        }
    }
}
