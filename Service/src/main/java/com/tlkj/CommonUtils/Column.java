package com.tlkj.CommonUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    public boolean isKey() default false;

    public boolean isAuto() default false;

    public boolean isRequire() default false;

    public boolean AllowInsert() default true;

    public String InsertDefault() default "";

    public boolean AllowUpdate() default true;

    public String UpdateDefault() default "";

    public String FieldName() default "";

    public String FieldDesc() default "";

    public int DBType() default DBType.ftString;

    public int MinLength() default 0;

    public int MaxLength() default 100;

    public String fkTable() default "";

    public String fkText() default "";

    public String fkValue() default "";

    public String fkWhere() default "";

}