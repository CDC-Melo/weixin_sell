package com.imooc.weixin.enums;
import lombok.Getter;
import org.aspectj.apache.bcel.classfile.Code;

//商品状态
@Getter
public enum ProductStatusEnum implements CodeEnum
{
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message)
    {
        this.code = code;
        this.message = message;
    }
}
