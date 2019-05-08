package com.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "locations")
public class Location {
    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue (generator = "increment")
    private Long id;

    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @Column(name = "x")
    private Double x;

    @Column(name = "y")
    private Double y;

    @Column(name = "head")
    private boolean head;
}
