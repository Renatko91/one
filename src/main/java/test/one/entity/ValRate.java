package test.one.entity;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.time.LocalDate;

@Entity
@Table(name = "valuta_rates")
@XmlType(name = "ValRate")
@XmlAccessorType(XmlAccessType.NONE)
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @XmlAttribute(name = "ID")
    @Column(name = "valcode_id")
    String valcode_id;

    @Column(name = "date")
    LocalDate date;

    @XmlElement(name = "Value")
    String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValcode_id() {
        return valcode_id;
    }

    public void setValcode_id(String valcode_id) {
        this.valcode_id = valcode_id;
    }
}
