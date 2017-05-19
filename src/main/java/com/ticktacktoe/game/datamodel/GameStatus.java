package com.ticktacktoe.game.datamodel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "GameStatus")

@NamedQuery(name="GameStatus.findById", query="SELECT a FROM GameStatus a where a.id = :id")
public class GameStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @NotNull
    @Column(name = "activeplayer")
    private String activePlayer;

    @Column(name = "row0_col0")
    private String row0_col0;
    @Column(name = "row0_col1")
    private String row0_col1;
    @Column(name = "row0_col2")
    private String row0_col2;

    @Column(name = "row1_col0")
    private String row1_col0;
    @Column(name = "row1_col1")
    private String row1_col1;
    @Column(name = "row1_col2")
    private String row1_col2;

    @Column(name = "row2_col0")
    private String row2_col0;
    @Column(name = "row2_col1")
    private String row2_col1;
    @Column(name = "row2_col2")
    private String row2_col2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }

    public String getRow0_col0() {
        return row0_col0;
    }

    public void setRow0_col0(String row0_col0) {
        this.row0_col0 = row0_col0;
    }

    public String getRow0_col1() {
        return row0_col1;
    }

    public void setRow0_col1(String row0_col1) {
        this.row0_col1 = row0_col1;
    }

    public String getRow0_col2() {
        return row0_col2;
    }

    public void setRow0_col2(String row0_col2) {
        this.row0_col2 = row0_col2;
    }

    public String getRow1_col0() {
        return row1_col0;
    }

    public void setRow1_col0(String row1_col0) {
        this.row1_col0 = row1_col0;
    }

    public String getRow1_col1() {
        return row1_col1;
    }

    public void setRow1_col1(String row1_col1) {
        this.row1_col1 = row1_col1;
    }

    public String getRow1_col2() {
        return row1_col2;
    }

    public void setRow1_col2(String row1_col2) {
        this.row1_col2 = row1_col2;
    }

    public String getRow2_col0() {
        return row2_col0;
    }

    public void setRow2_col0(String row2_col0) {
        this.row2_col0 = row2_col0;
    }

    public String getRow2_col1() {
        return row2_col1;
    }

    public void setRow2_col1(String row2_col1) {
        this.row2_col1 = row2_col1;
    }

    public String getRow2_col2() {
        return row2_col2;
    }

    public void setRow2_col2(String row2_col2) {
        this.row2_col2 = row2_col2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameStatus that = (GameStatus) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
