package com.smalik.sqldata;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(Person.PersonId.class)
@Table(name = "person")
public class Person {

    @Id
    String firstName;
    @Id
    String lastName;
    int age;

    @CreationTimestamp
    @Column(updatable = false)
    OffsetDateTime created;

    @UpdateTimestamp
    OffsetDateTime updated;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class PersonId implements Serializable {
        String firstName;
        String lastName;
    }
}
