package cn.luozc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "country")
public class Country implements Serializable {

    @Id
    private int id;
    private String countryname;
    private String countrycode;

}
