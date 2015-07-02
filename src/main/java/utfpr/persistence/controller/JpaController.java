/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utfpr.persistence.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @version 1.0.0
 *
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 * <a href="http://www.utfpr.edu.br">Universidade Tecnológica Federal do Paraná</a>
 */
public class JpaController {
    protected static EntityManagerFactory emf = null;

    public JpaController() {
    }

    public EntityManagerFactory getEMFactory() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("InscricaoPU");
        return emf;
    }

    public EntityManager getEntityManager() {
        return getEMFactory().createEntityManager();
    }
}
