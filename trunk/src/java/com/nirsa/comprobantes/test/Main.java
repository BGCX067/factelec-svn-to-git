/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.test;

import com.nirsa.comprobantes.persistencia.bean.Rol;
import com.nirsa.comprobantes.persistencia.dao.hibernate.RolDaoHibernate;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class Main {
    
    public static void main(String[] args) {
        RolDaoHibernate dao = new RolDaoHibernate();
        List<Rol> roles = dao.findAll();
        for (Rol rol : roles) {
            System.out.println(rol);
        }
    }
}
