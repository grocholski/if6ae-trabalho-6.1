/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Wilson
 */
@FacesValidator("CEPValidator")
public class CEPValidator implements Validator {
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        Integer cep = (Integer) o;
        if (cep < 1000) {        
            throw new ValidatorException(new FacesMessage("CEP \'" + cep + "\' inválido."));
        }
    }
}
