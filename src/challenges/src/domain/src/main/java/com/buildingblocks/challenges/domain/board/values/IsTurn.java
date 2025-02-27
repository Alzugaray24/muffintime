package com.buildingblocks.challenges.domain.board.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class IsTurn implements IValueObject {

    private final Boolean value;

    private IsTurn(Boolean value) {
        this.value = value;
        validate();
    }

    public static IsTurn of(Boolean value) {
        return new IsTurn(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateBoolean(value, "IsTurn value cannot be null");
    }

    public Boolean getValue() {
        return value;
    }
}