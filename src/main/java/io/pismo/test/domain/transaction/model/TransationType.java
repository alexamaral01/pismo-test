package io.pismo.test.domain.transaction.model;

import java.math.BigDecimal;

/**
 * The enum Transation type.
 */
public enum TransationType {
    /**
     * Entry transation type.
     */
    ENTRY,
    /**
     * Exit transation type.
     */
    EXIT;

    /**
     * Ajust signal.
     *
     * @param value the value
     * @return the big decimal
     */
    public BigDecimal ajustSignal(BigDecimal value){
        return TransationType.ENTRY == this ? value.abs() : value.negate() ;
    }
}
