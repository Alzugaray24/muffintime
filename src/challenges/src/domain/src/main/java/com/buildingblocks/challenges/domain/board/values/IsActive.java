package com.buildingblocks.challenges.domain.board.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class IsActive implements IValueObject {

    private final Boolean value;

    private IsActive(Boolean value) {
        this.value = value;
        validate();
    }

    public static IsActive of(Boolean value) {
        return new IsActive(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateBoolean(value, "IsActive value cannot be null");
    }

    public Boolean getValue() {
        return value;
    }
}
