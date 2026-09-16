SELECT DISTINCT
    d.ID,
    d.EMAIL,
    d.FIRST_NAME,
    d.LAST_NAME
FROM
    developers d
JOIN
    SKILLCODES s ON (d.SKILL_CODE & s.CODE) > 0
WHERE
    s.NAME LIKE 'Py%' OR s.NAME = 'C#'
ORDER BY
    d.ID;