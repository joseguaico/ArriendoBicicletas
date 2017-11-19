package com.arriendo.converters;

import com.arriendo.utilidades.Utilidades;
import java.time.LocalTime;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("localTimeCalConverter")
public class LocalTimeCalConverter implements Converter
{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) 
    {
        LocalTime ret = LocalTime.now();
        
        try
        {
            Date temp = Utilidades.stringToTime(value);
            ret = LocalTime.of(temp.getHours(), temp.getMinutes());
            
        }catch(Exception ex)
        {
        
        }
        
        
        return ret;
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) 
    {
        return value.toString();
    }
}

