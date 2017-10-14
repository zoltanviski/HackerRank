--  Author: Zoltan Viski (vizoli)
--          vizoli.hu
--          github.com/zoltanviski
--          hackerrank.com/zoltanviski

-- Problem: Problem: https://www.hackerrank.com/challenges/revising-the-select-query

SELECT * 
FROM CITY
WHERE COUNTRYCODE = 'USA' 
      AND POPULATION > 100000;