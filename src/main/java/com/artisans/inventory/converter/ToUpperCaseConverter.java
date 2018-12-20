/**
 * 
 */
package com.artisans.inventory.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;

/**
 * @author bjacob
 *
 */
@SuppressWarnings("rawtypes")
@Component(value = "toUpperCaseConverter")
@FacesConverter("com.artisans.inventory.converter.toUpperCaseConverter")
public class ToUpperCaseConverter implements Converter, Serializable {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        return (submittedValue != null) ? submittedValue.toUpperCase() : null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        return (modelValue != null) ? modelValue.toString() : "";
    }
}
