/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Idioma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wilson
 */
public class IdiomaJpaController extends JpaController {

    @PersistenceContext
    private EntityManager em;

    public IdiomaJpaController() {
    }

    public List<Idioma> findAll() {
        TypedQuery<Idioma> q = em.createQuery(
                "select i from Idioma i order by i.descricao",
                Idioma.class);
        return q.getResultList();
    }
}
