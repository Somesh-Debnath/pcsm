package com.pcms.pcms_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "user_plans")
public class UserPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer userPlanId;

    @Column
    private Integer planId;

    @Column
    private String planName;

    @Column
    private double price;

    private String location;
    private String requestedBy;
    private String requestedDate;

    @Column
    private String requiredFrom;

    @Column
    private String requiredTo;

    @Column(columnDefinition = "boolean default false")
    private boolean autoTerminated;

    @Column(columnDefinition = "boolean default false")
    private boolean alertRequired;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    private String status;

    @OneToMany(mappedBy = "userPlans", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Plans> plans;

    @PrePersist
    @PreUpdate
    private void validateDates() {
        if (requiredFrom != null && requiredTo != null && requiredFrom.compareTo(requiredTo) >= 0) {
            throw new IllegalArgumentException("RequiredFrom should be earlier than RequiredTo");
        }
    }
}