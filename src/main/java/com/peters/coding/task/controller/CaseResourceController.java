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
       return caseService.getCasesWithStatus(status);
    }

    @GetMapping("/cases/user/{userId}")
    List<Case> getOpenCases(@PathVariable Long userId) {
        return caseService.getOpenCasesByUserId(userId);
    }

    @GetMapping("/cases/user/{userId}/status/{status}")
    List<Case> getOpenCases(@PathVariable Long userId, @PathVariable Case.Status status) {
        return caseService.getOpenCases(userId, status);
    }

    @GetMapping("/case/{caseId}")
    Case getCase(@PathVariable Long caseId) {
        return caseService.getCaseById(caseId);
    }

    @PostMapping(value = "/case/create", consumes = "application/json")
    Case createCase(@RequestBody Case toCreate) {
        return caseService.createCase(toCreate);
    }

    @PostMapping(value = "/case/{caseId}/addNote", consumes = "text/plain")
    Note addNote(@PathVariable Long caseId, @RequestBody String detail) {
        return caseService.addNoteToCase(caseId, detail);
    }
}
