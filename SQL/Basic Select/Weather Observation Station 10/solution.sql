--  Author: Zoltan Viski (vizoli)
--          vizoli.hu
--          github.com/zoltanviski
--          hackerrank.com/zoltanviski

-- Problem: https://www.hackerrank.com/challenges/weather-observation-station-10

SELECT DISTINCT CITY 
FROM STATION
WHERE CITY REGEXP '[^aeiou]$';