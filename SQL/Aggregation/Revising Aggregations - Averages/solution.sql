--  Author: Zoltan Viski (vizoli)
--          vizoli.hu
--          github.com/zoltanviski
--          hackerrank.com/zoltanviski

-- Problem: https://www.hackerrank.com/challenges/revising-aggregations-the-average-function

SELECT AVG(POPULATION) 
FROM CITY
WHERE DISTRICT = 'California';