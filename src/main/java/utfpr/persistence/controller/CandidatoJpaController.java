package utfpr.persistence.controller;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

/**
 * Desenvolvimento de aplicações Web
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class CandidatoJpaController extends JpaController {

    @PersistenceContext
    private EntityManager em;
    
    public CandidatoJpaController() {
    }
    
    public List<Candidato> findByIdioma() {
        TypedQuery<Candidato> q = em.createQuery(
                "select c from Candidato c order by c.idioma.descricao, c.nome",
                Candidato.class);
        return q.getResultList();
    }
    
    public List<Candidato> findByIdioma(Idioma idioma) {
        TypedQuery<Candidato> q = em.createQuery(
                "select c from Candidato c where c.idioma = :p order by c.nome",
                Candidato.class);
        q.setParameter("p", idioma);
        return q.getResultList();
    }
    
    public List<Candidato> findByIdioma(Integer idioma) {
        TypedQuery<Candidato> q = em.createQuery(
                "select c from Candidato c where c.idioma.codigo = :p order by c.nome",
                Candidato.class);
        q.setParameter("p", idioma);
        return q.getResultList();
    }
    
    public void salvar(Candidato candidato) throws Exception {
        em.persist(candidato);
    }
}
