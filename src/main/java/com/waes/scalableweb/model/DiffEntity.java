package com.waes.scalableweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DiffEntity {

    @Id
    private Integer id;

    private String left;

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
