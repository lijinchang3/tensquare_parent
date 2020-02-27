package com.tensquare.base.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "tb_label")
@Data
public class Label implements Serializable {
    @Id
    private String id;
    private String labelname;
    private String state;
    private Long fans;
    private String recommend;
}
