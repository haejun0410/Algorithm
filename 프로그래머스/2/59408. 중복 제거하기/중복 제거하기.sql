-- 코드를 입력하세요
SELECT count(NAME) AS count
FROM
    (SELECT DISTINCT NAME
    FROM ANIMAL_INS
    WHERE NAME is not NULL) AS a;