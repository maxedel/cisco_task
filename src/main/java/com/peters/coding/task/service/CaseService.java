package com.peters.coding.task.service;

import com.peters.coding.task.entity.Case;
import com.peters.coding.task.entity.Note;
import com.peters.coding.task.repository.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaseService {

    private CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    // TODO: Query for cases with a specified status.
    public List<Case> getCasesWithStatus(Case.Status status) {
        return caseRepository.getCasesWithStatus(status);
    }

    public List<Case> getOpenCasesByUserId(Long userId) {
        return caseRepository.getOpenCasesByUserId(userId);
    }

    public List<Case> getOpenCases(Long userId, Case.Status status) {
        return caseRepository.getOpenCasesByUserIdAndStatus(userId, status);
    }

    public Case getCaseById(Long caseId) {
        return caseRepository.getCaseByCaseId(caseId);
    }

    public Case createCase(Case toCreate) {
        return caseRepository.save(toCreate);
    }

    public Note addNoteToCase(Long caseId, String detail) {
        return caseRepository.addNoteToCase(caseId, detail);
    }
}
