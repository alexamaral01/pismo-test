package io.pismo.test.domain.transaction.service;

import io.pismo.test.domain.transaction.model.OperationType;
import io.pismo.test.domain.transaction.repository.OperationTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultOperationTypeService implements OperationTypeService{

    private OperationTypeRepository operationTypeRepository;

    @Override
    public OperationType retrieve(Long id) {
        return operationTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Operation type not found."));
    }
}
