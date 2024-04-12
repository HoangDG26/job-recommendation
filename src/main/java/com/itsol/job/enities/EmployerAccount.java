package com.itsol.job.enities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "employer_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners({AuditingEntityListener.class})
public class EmployerAccount extends BaseEntity{
    String username;
    String password;
    Boolean isBanned;
    LocalDateTime lockedUntil;
    LocalDateTime lastLogin;
    @OneToMany(mappedBy = "employerAccount", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Collection<Job> jobs;
}
