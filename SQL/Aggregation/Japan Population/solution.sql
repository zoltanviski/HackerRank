--  Author: Zoltan Viski (vizoli)
--          vizoli.hu
--          github.com/zoltanviski
--          hackerrank.com/zoltanviski

-- Problem: https://www.hackerrank.com/challenges/japan-population

SELECT SUM(POPULATION)
FROM CITY
WHERE COUNTRYCODE = 'JPN';