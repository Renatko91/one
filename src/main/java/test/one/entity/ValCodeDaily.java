package test.one.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "valuta_daily_codes")
@XmlType(name = "Item")
@XmlAccessorType(XmlAccessType.NONE)
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValCodeDaily {
    @XmlAttribute(name = "ID")
    @Id
    @Column(name = "id")
    String id;

    /*@OneToMany(mappedBy = "vcode", fetch = FetchType.LAZY)
    private List<ValRate> valRates;*/

    @XmlElement(name = "Name")
    @Column(name = "name")
    String name;

    @XmlElement(name = "EngName")
    @Column(name = "eng_name")
    String engName;

    @XmlElement(name = "ISO_Char_Code")
    @Column(name = "code")
    String code;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEngName() {
        return engName;
    }

    public String getCode() {
        return code;
    }
}
