package com.jayklef.JerryFinanceSchool.model;

import lombok.Data;

@Data
public class Holiday {
    private final String Day;
    private final String reason;
    private final Type type;

    public enum Type{
        RELIGIOUS, FESTIVE, FEDERAL
    }
}
