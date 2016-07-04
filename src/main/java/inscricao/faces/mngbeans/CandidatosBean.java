/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.CandidatoJpaController;
import utfpr.persistence.controller.IdiomaJpaController;

/**
 *
 * @author alexandre
 */
@Named
@SessionScoped
public class CandidatosBean extends PageBean implements Serializable {
    
    private Idioma idioma = new Idioma();
    private List<Candidato> candidatos = new ArrayList<>();
    
    @Inject
    private IdiomaJpaController idiomaJpaController;
    @Inject
    private CandidatoJpaController candidatoJpaController;
    
    @TransactionAttribute
    public List<Idioma> getIdiomas() {
        List<Idioma> idiomas;
        try {
            idiomas = idiomaJpaController.findAll();
        } catch (Exception e) {
            idiomas = new ArrayList<>(0);
            log("Lista de idiomas", e);
        }
        return idiomas;
    }
    
    @Transactional
    @TransactionAttribute
    public String filtrar() {
        
        System.out.println(idioma.getDescricao()+idioma.getCodigo());
        try {
            
            if (idioma.getCodigo() == 0) {
                candidatos = candidatoJpaController.findByIdioma();
            }
            else {
                candidatos = candidatoJpaController.findByIdioma(
                        idioma.getCodigo());
            }
        } catch (Exception e) {
            candidatos = new ArrayList<>(0);
            log("Lista de candidatos", e);
        }
        return "";
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}
