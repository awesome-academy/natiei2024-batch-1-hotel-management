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
}
