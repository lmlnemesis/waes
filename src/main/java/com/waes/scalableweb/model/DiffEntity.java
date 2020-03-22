package com.waes.scalableweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DiffEntity {

    @Id
    @Column
    private Integer id;

    @Column
    private String left;

    @Column
    private String right;

    @Override
    public String toString() {
        return "DiffEntity{" +
                "id=" + id +
                ", left='" + left + '\'' +
                ", right='" + right + '\'' +
                '}';
    }
}
