package com.buildingblocks.challenges.domain.board.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Type implements IValueObject {

    private final String value;

    private Type(String value) {
        this.value = value;
        validate();
    }

    public static Type of(String value) {
        return new Type(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(value, "Title text cannot be empty");
    }

    public String getValue() {
        return value;
    }
}
