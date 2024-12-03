package com.KajadhECommerce.Kajadh.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class DateOfBirth {
    private byte date;
    private byte month;

    private short year;

    public  DateOfBirth() {
       super();
    }
    public DateOfBirth(byte date, byte month, short year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public byte getDate() {
        return date;
    }

    public void setDate(byte date) {
        this.date = date;
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "date=" + date +
                ", month='" + month + '\'' +
                ", year=" + year +
                '}';
    }
}
