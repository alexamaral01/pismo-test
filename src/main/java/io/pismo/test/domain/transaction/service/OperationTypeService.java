package io.pismo.test.domain.transaction.service;

import io.pismo.test.domain.transaction.model.OperationType;

/**
 * The interface Operation type service.
 */
public interface OperationTypeService {

    /**
     * Retrieve operation type.
     *
     * @param id the id
     * @return the operation type
     */
    OperationType retrieve( Long id );

}
