package com.peters.coding.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "NOTES")
@Getter
@Setter
@NoArgsConstructor
public class Note {

    @Id
    private Long noteId;
    private Integer caseId;
    private String details;
}
