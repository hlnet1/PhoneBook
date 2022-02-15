
# -- some test entries
INSERT INTO entries (id,first_name, last_name)
VALUES
(1, 'John', 'Smith'),
(2, 'Mary', 'Jane'),
(3, 'George', 'Smith'),
(4, 'Peter', 'Bross'),
(5, 'Jane', 'Ayre'),
(6, 'Anna', 'Thomson');
# -- some test contacts
INSERT INTO contacts (id,phone_number,type,entry_id)
VALUES
(1,'+359877666555', 'HOME',1),
(2, '+359877000000','WORK',1),
(3, '+359877666666','OFFICE',1),
(4, '+359877444444','OFFICE',2),
(5, '+359877555555','HOME',2),
(6, '+359877111111','HOME',4),
(7, '+359877222000','WORK',5),
(8, '+359877222234','HOME',5),
(9, '+359877222456','OFFICE',5),
(10, '+359877222111','WORK',3),
(11, '+359877222135','HOME',6),
(12, '+359877222246','WORK',6),
(13, '+359877222257','OFFICE',6);