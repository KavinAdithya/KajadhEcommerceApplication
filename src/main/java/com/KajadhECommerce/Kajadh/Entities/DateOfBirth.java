package com.KajadhECommerce.Kajadh.Entities;

import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Embeddable
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
	public int hashCode() {
		return Objects.hash(date, month, year);
	}
	
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateOfBirth other = (DateOfBirth) obj;
		return date == other.date && month == other.month && year == other.year;
	}

	@Override
    public String toString() {
        return "DateOfBirth{" +
                "date=" + date +
                ", month=" + month  +
                ", year=" + year +
                '}';
    }
}
