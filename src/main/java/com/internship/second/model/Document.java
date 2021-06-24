package com.internship.second.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "documents")
@Getter
@Setter
@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "harvard_doc", nullable = false)
    @NotEmpty
    private String harvardDoc;

    @Column(name = "columbia_doc", nullable = false)
    @NotEmpty
    private String columbiaDoc;

    @ManyToOne
    @JoinColumn(name="participant_id")
    @JsonBackReference
    private Participant participant;

}
