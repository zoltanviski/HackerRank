--  Author: Zoltan Viski (vizoli)
--          vizoli.hu
--          github.com/zoltanviski
--          hackerrank.com/zoltanviski

-- Problem: https://www.hackerrank.com/challenges/revising-the-select-query-2

SELECT NAME 
FROM CITY
WHERE COUNTRYCODE = 'USA' 
      AND POPULATION > 120000;