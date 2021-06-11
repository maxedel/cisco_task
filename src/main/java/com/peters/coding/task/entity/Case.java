package com.peters.coding.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CASES")
@Getter
@Setter
@NoArgsConstructor
public class Case {

    @Id
    private Long caseId;
    private String title;
    private String description;
    private Integer severity;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy="caseId")
    private List<Note> notes;

    public enum Status {OPEN, CLOSED}
}
