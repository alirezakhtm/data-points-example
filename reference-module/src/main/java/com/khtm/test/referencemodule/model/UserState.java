package com.khtm.test.referencemodule.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
public enum UserState {

    UPDATE(1, "UPDATE"),
    INSERT(2, "INSERT");

    private long value;
    private String strValue;

    UserState(long value, String strValue){
        this.value = value;
        this.strValue = strValue;
    }

    @JsonValue
    public long getValue() {
        return value;
    }
}
