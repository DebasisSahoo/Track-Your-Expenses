package com.managedbean;


import com.bean.LoginSuccess;
import com.factory.ClassFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

@ManagedBean
@RequestScoped
public class LoginSuccessBean {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //private Integer id;
    static private Integer id = 1000;


    private String uname;
    private Integer mobile;
    private Integer wifi;
    private Integer book;
    private Integer bus;
    private Integer home;
    private Integer shopping;
    private Integer food;
    private Integer party;
    private Integer other;
    private Calendar dateOfData;
    private String message;
    private Calendar daily_date;
    private Integer monthly_month;
    private Integer daily_count;
    private Integer monthly_count;
    private Integer monthly_year;


    public Integer getMonthly_count() {
        return monthly_count;
    }

    public void setMonthly_count(Integer monthly_count) {
        this.monthly_count = monthly_count;
    }

    public Integer getDaily_count() {
        return daily_count;
    }

    public void setDaily_count(Integer daily_count) {
        this.daily_count = daily_count;
    }

    public Calendar getDaily_date() {
        return daily_date;
    }

    public void setDaily_date(Calendar daily_date) {
        this.daily_date = daily_date;
    }

    public Integer getmonthly_month() {
        return monthly_month;
    }

    public void setmonthly_month(Integer monthly_month) {
        this.monthly_month = monthly_month;
    }

    public Integer getMonthly_year() {
        return monthly_year;
    }

    public void setMonthly_year(Integer monthly_year) {
        this.monthly_year = monthly_year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBus() {
        return bus;
    }

    public void setBus(Integer bus) {
        this.bus = bus;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Integer getShopping() {
        return shopping;
    }

    public void setShopping(Integer shopping) {
        this.shopping = shopping;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getParty() {
        return party;
    }

    public void setParty(Integer party) {
        this.party = party;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    public Calendar getDateOfData() {
        return dateOfData;
    }

    public void setDateOfData(Calendar dateOfData) {
        this.dateOfData = dateOfData;
    }


    public String submitData(String uname) {


        LoginSuccess ls = new LoginSuccess();
        ls.setUname(uname);
        ls.setBook(book);
        ls.setBus(bus);
        ls.setDateOfData(dateOfData);
        ls.setFood(food);
        ls.setHome(home);
        ls.setMobile(mobile);
        ls.setOther(other);
        ls.setParty(party);
        ls.setShopping(shopping);
        ls.setWifi(wifi);


        try {
            this.message = ClassFactory.createLoginSuccessService().calculate(ls);
            if (this.message != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("sucess"));
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return message;
    }


    public String calculate_daily_expenses(String uname) {
        String daily_message = null;

        if (daily_date == null) {
            daily_message = "Enter a valid daily_date";
        } else {
            try {

                logger.info("uname in lsbean :" + this.uname);

                daily_count = ClassFactory.createLoginSuccessService().daily_calculate(daily_date, uname);
                daily_message = "Your total Expenditure of " + daily_date + " is " + daily_count;

            } catch (Exception e) {

                logger.severe(e.getMessage());
            }
        }
        logger.info("daily :" + daily_message);
        return daily_message;
    }


    public String calculate_monthly_expenses(String uname) {
        String daily_message = null;


        try {
            int year = this.monthly_year;
            int month = this.monthly_month;

            Calendar lastDay = new GregorianCalendar(year, month, Calendar.DAY_OF_MONTH);
            lastDay.set(lastDay.DAY_OF_MONTH, lastDay.getActualMaximum(lastDay.DAY_OF_MONTH));


            Calendar firstDay = new GregorianCalendar(year, month, Calendar.DAY_OF_MONTH);
            firstDay.set(firstDay.DAY_OF_MONTH, firstDay.getActualMinimum(firstDay.DAY_OF_MONTH));

            monthly_count = ClassFactory.createLoginSuccessService().monthly_calculate(firstDay, lastDay, uname);


        } catch (Exception e) {

            logger.severe(e.getMessage());
        }


        return daily_message;
    }


}
