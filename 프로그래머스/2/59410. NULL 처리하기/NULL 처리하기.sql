-- 코드를 입력하세요
SELECT
    animal_type,
    CASE
        WHEN name IS NULL THEN "No name"
        ELSE name
    END AS name,
    SEX_UPON_INTAKE
FROM animal_ins
ORDER BY animal_id