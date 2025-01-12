SELECT
    BOOK_ID,
    DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d")
FROM BOOK
WHERE PUBLISHED_DATE LIKE "2021%"
and CATEGORY = '인문'
ORDER BY PUBLISHED_DATE