package com.peters.coding.task.repository;

import com.peters.coding.task.entity.Case;
import com.peters.coding.task.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CaseRepository extends JpaRepository<Case, Long> {

    List<Case> getOpenCasesByUserId(Long userId);

    @Query("SELECT c FROM Case c WHERE LOWER(c.status) = LOWER(:status)")
    List<Case> getCasesWithStatus(@Param("status") Case.Status status);

    @Query("SELECT c FROM Case c WHERE LOWER(c.user.id) = LOWER(:userId) and LOWER(c.status) = LOWER(:status)")
    List<Case> getOpenCasesByUserIdAndStatus(@Param("userId") Long userId, @Param("status") Case.Status status);

    Case getCaseByCaseId(Long caseId);

    @Query("update Note n set n.details = LOWER(:detail) where LOWER(n.caseId) = LOWER(:caseId)")
    Note addNoteToCase(@Param("caseId") Long caseId,@Param("detail") String detail);
}
