--  Author: Zoltan Viski (vizoli)
--          vizoli.hu
--          github.com/zoltanviski
--          hackerrank.com/zoltanviski

-- Problem: https://www.hackerrank.com/challenges/asian-population

SELECT SUM(CITY.POPULATION) 
FROM CITY, COUNTRY
WHERE CITY.COUNTRYCODE = COUNTRY.CODE 
      AND COUNTRY.CONTINENT = 'Asia';