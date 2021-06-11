INSERT INTO USERS (id, firstName, lastName, email) VALUES
  (1, 'Frodo', 'Baggins', 'Baggins@mail.ru'),
  (2, 'Bilbo', 'Baggins', 'Baggins@mail.com');

  INSERT INTO CASES (caseId, title, description, severity, status, user_id, case_id) VALUES
  (1, 'Case1', 'Case 1 desc', 500, OPEN, 1, 1),
  (2, 'Case2', 'Case 2 desc', 500, CLOSED, 2, 1),
  (3, 'Case3', 'Case 3 desc', 500, OPEN, 3, 2),
  (4, 'Case4', 'Case 4 desc', 500, CLOSED, 4, 2),
  (5, 'Case5', 'Case 5 desc', 500, OPEN, 5, 2);

INSERT INTO NOTES (noteId, caseId, details) VALUES
  (1, 1, 'Details1'),
  (2, 1, 'Details2');
