--  Author: Zoltan Viski (vizoli)
--          vizoli.hu
--          github.com/zoltanviski
--          hackerrank.com/zoltanviski

-- Problem: https://www.hackerrank.com/challenges/average-population-of-each-continent

SELECT COUNTRY.CONTINENT, FLOOR(AVG(CITY.POPULATION))
FROM CITY 
INNER JOIN COUNTRY ON CITY.COUNTRYCODE = COUNTRY.CODE
GROUP BY COUNTRY.CONTINENT;