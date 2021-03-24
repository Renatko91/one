package test.one.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "ValCurs")
public class ValRateRoot {
    @XmlAttribute(name = "Date")
    String date;
    @XmlElement(name = "Valute")
    public List<ValRate> valutes = new ArrayList<>();

    private LocalDate getDate() {
        String[] s = date.split("\\.");
        int year = Integer.parseInt(s[2]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[0]);
        return LocalDate.of(year, month, day);
    }

    public void prepareItems() {
        LocalDate localDate = getDate();
        valutes.forEach(v -> {
            v.setDate(localDate);
        });
    }
}