package com.udacity.vehicles.domain.car;

import com.udacity.vehicles.domain.Condition;
import com.udacity.vehicles.domain.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Declares the Car class, related variables and methods.
 */
@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Valid
    @Embedded
    private Details details = new Details();

    @Valid
    @Embedded
    private Location location = new Location(0d, 0d);

    @Transient
    private String price;

    public Car(Long id, LocalDateTime createdAt, LocalDateTime modifiedAt, Condition condition, Details details, Location location, String price) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.condition = condition;
        this.details = details;
        this.location = location;
        this.price = price;
    }
}
