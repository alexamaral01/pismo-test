package io.pismo.test.domain.transaction.model;

import java.math.BigDecimal;

public enum TransationType {
    ENTRY, EXIT;

    public BigDecimal ajustSignal(BigDecimal value){
        return TransationType.ENTRY == this ? value.abs() : value.negate() ;
    }
}
