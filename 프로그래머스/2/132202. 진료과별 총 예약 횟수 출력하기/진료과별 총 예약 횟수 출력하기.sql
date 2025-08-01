-- 코드를 입력하세요
SELECT
    MCDP_CD AS "진료과코드",
    COUNT(*) AS "5월예약건수"
FROM 
    APPOINTMENT
WHERE 
    APNT_YMD >= '2022-05-01' AND APNT_YMD <= '2022-05-31'
GROUP BY
    MCDP_CD
ORDER BY
        COUNT(*),
        MCDP_CD