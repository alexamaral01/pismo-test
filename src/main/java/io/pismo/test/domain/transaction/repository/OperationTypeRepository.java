package io.pismo.test.domain.transaction.repository;

import io.pismo.test.domain.transaction.model.OperationType;
import org.springframework.data.repository.CrudRepository;

public interface OperationTypeRepository extends CrudRepository<OperationType, Long> {

}
