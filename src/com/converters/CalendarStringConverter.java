package com.converters;

import src.com.exception.ExceptionUtility;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

@FacesConverter("calendarConv")
public class CalendarStringConverter implements Converter {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public Object getAsObject(FacesContext context, UIComponent component,
                              String str) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy");
        Date dateReference;
        Calendar calendar = Calendar.getInstance();

        if ("".equals(str)) {
            return null;
        }
        try {
            dateReference = simpleDate.parse(str);

            calendar.setTime(dateReference);

        } catch (ParseException e) {
            logger.severe(ExceptionUtility.getStacktrace(e));
        }
        return calendar;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
                              Object obj) {
        // TODO Auto-generated method stub
        String textDate = null;
        if (obj == null) {
            return null;
        }
        try {
            Calendar c = (Calendar) obj;
            Date d = c.getTime();
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy");
            textDate = simpleDate.format(d);
        } catch (Exception e) {
            logger.severe(ExceptionUtility.getStacktrace(e));
        }

        return textDate;
    }

}
