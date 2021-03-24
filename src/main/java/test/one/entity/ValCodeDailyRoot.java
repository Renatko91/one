package test.one.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Valuta")
public class ValCodeDailyRoot {
    @XmlElement(name = "Item")
    public List<ValCodeDaily> list = new ArrayList<>();
}

