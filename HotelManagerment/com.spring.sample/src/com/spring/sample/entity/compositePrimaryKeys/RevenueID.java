package com.spring.sample.entity.compositePrimaryKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class RevenueID implements Serializable {

    @Column(name = "Month")
    private Integer month;

    @Column(name = "Year")
    private Integer year;

    private Integer roomTypeID;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getRoomTypeID() {
		return roomTypeID;
	}

	public void setRoomTypeID(Integer roomTypeID) {
		this.roomTypeID = roomTypeID;
	}
    
    
}
