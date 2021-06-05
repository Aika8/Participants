package com.internship.second.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "phones")
@Getter
@Setter
@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "number", nullable = false)
    @NotEmpty
    @Size(max = 11)
    private String number;

    @ManyToOne
    @JoinColumn(name="person_id")
    @JsonBackReference
    private Person person;

}
