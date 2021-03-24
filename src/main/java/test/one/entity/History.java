package test.one.entity;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "history")
@ToString
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @Column(name = "code_from")
    String code_from;

    @Column(name = "code_to")
    String code_to;

    @Column(name = "val_from")
    double val_from;

    @Column(name = "val_to")
    double val_to;

    @Column(name = "date")
    LocalDate date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode_from() {
        return code_from;
    }

    public void setCode_from(String code_from) {
        this.code_from = code_from;
    }

    public String getCode_to() {
        return code_to;
    }

    public void setCode_to(String code_to) {
        this.code_to = code_to;
    }

    public double getVal_from() {
        return val_from;
    }

    public void setVal_from(double val_from) {
        this.val_from = val_from;
    }

    public double getVal_to() {
        return val_to;
    }

    public void setVal_to(double val_to) {
        this.val_to = val_to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
