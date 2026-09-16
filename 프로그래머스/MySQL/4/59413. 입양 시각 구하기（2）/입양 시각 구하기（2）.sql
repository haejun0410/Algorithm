with recursive rc as (
    select 0 as hour
    union all
    select hour + 1 from rc where hour < 23
)

SELECT
    a.HOUR,
    CASE
        WHEN b.COUNT IS NULL THEN 0
        ELSE b.COUNT
    END AS COUNT
FROM rc AS a
LEFT JOIN (
    SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
    FROM ANIMAL_OUTS
    GROUP BY HOUR
) AS b
ON a.HOUR = b.HOUR