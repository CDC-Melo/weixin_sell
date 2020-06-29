package com.imooc.weixin.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;

@Entity
@DynamicUpdate
@Data
public class ProductCategory
{
    //类目id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    //类目名称
    private String categoryName;

    //类目编号
    private Integer categoryType;

    //private Time createTime;

    //private Time updateTime;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType)
    {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
