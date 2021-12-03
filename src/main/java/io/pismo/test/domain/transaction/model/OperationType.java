package io.pismo.test.domain.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OPERATIONS_TYPES")
@NoArgsConstructor
public class OperationType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_type_seq_gen")
    @SequenceGenerator(name = "operation_type_seq_gen", sequenceName = "operations_types_operation_type_id_seq", allocationSize = 1)
    private Long OperationTypeId;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private TransationType transationType;

    public OperationType(String description, TransationType transationType) {
        this.description = description;
        this.transationType = transationType;
    }
}
