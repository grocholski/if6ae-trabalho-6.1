package inscricao.faces.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * IF6EA Desenvolvimento de Aplicações Web
 * Exemplo de aplicação Web com JSF.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
@FacesConverter("CEPConverter")
public class CEPConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string == null || string.isEmpty() ? null : Integer.valueOf(string.replace("-", ""));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Integer cep = (Integer) o;
        return String.format("%05d-%03d", cep / 1000, cep % 1000);
    }
    
}
