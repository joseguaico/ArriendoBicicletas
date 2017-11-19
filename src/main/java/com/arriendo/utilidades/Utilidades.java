package com.arriendo.utilidades;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.regex.Pattern;

public class Utilidades 
{
     public static String formatearNumero(Double valor)
    {
        DecimalFormat df = new DecimalFormat("###,###.##");
        return df.format(valor);
    }
     public static String formatearNumero(Long valor)
    {
        DecimalFormat df = new DecimalFormat("###,###.##");
        return df.format(valor);
    }
    public static boolean validarRut(int rut, char dv)
    {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10)
        {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
     public static boolean validarNumeroDecimal(String cantidad)
    {
         try {
            Double dd = Double.parseDouble(cantidad);
            return true;
        } catch (Exception e) {
            return false;
        }
    }    
    public static boolean validarFechaConFormato(String fecha)
    {
         try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            df.setLenient(false);
            df.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean validarHoraConFormato(String hora)
    {
         try {
            DateFormat df = new SimpleDateFormat("HH:mm");
            df.setLenient(false);
            df.parse(hora);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static String formatearFecha(Date fecha)
    {
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            return sdf.format(fecha);
            
        } catch (Exception e) {
        }
        return fecha.toString();
    }
     public static String formatearFechaParaMySql(Date fecha)
    {
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(fecha);
            
        } catch (Exception e) {
        }
        return fecha.toString();
    }
     public static String formatearFechaHora(Date fecha)
    {
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy  HH:mm");
            return sdf.format(fecha);
            
        } catch (Exception e) {
        }
        return fecha.toString();
    }
    public static String formatearHora(Date fecha)
    {
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(fecha);
            
        } catch (Exception e) {
        }
        return fecha.toString();
    }
      public static String formatearHora(LocalTime time)
    {
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(time);
            
        } catch (Exception e) {
        }
        return time.toString();
    }
      
    public static boolean validarEmail(String email)
    {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        return pattern.matcher(email).matches();
    }
    
    public static Date stringToTime(String fecha) 
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.parse(fecha);
        }
        catch(Exception ex){}
        
        return null;
    }

}
