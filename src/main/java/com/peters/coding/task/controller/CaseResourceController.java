package com.peters.coding.task.controller;

import com.peters.coding.task.entity.Case;
import com.peters.coding.task.entity.Note;
import com.peters.coding.task.service.CaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseResourceController {

    private CaseService caseService;

    public CaseResourceController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("/cases/status/{status}")
    List<Case> getCasesWithStatus(@PathVariable Case.Status status) {
        // TODO: Query for cases with a specified status.
       return caseService.getCasesWithStatus(status);
    }

    @GetMapping("/cases/user/{userId}")
    List<Case> getOpenCases(@PathVariable Integer userId) {
        // TODO: Query for cases with a userId;
        return caseService.getOpenCasesByUserId(userId);
    }

    @GetMapping("/cases/user/{userId}/status/{status}")
    List<Case> getOpenCases(@PathVariable Integer userId, @PathVariable Case.Status status) {
        // TODO: Query for cases with a userId and status
        return caseService.getOpenCases(userId, status);
    }

    @GetMapping("/case/{caseId}")
    Case getCase(@PathVariable Integer caseId) {
        // TODO: Get a case by ID
        return caseService.getCaseById(caseId);
    }

    @PostMapping(value = "/case/create", consumes = "application/json")
    Case createCase(@RequestBody Case toCreate) {
        // TODO: Create a case and any associated records (user, notes)
        return caseService.createCase(toCreate);
    }

    @PostMapping(value = "/case/{caseId}/addNote", consumes = "text/plain")
    Note addNote(@PathVariable Integer caseId, @RequestBody String detail) {
        // TODO: Create a note for the specified case
        return caseService.addNoteToCase(caseId, detail);
    }
}
