package com.peters.coding.task.entity;

import java.util.List;

public class Case {

    private Integer caseId;
    private String title;
    private String description;
    private Integer severity;
    private Status status;
    private User user;
    private List<Note> notes;

    public enum Status {OPEN, CLOSED}
}
