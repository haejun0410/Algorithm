-- 코드를 입력하세요
SELECT count(USER_ID)
FROM USER_INFO
WHERE YEAR(JOINED)='2021' and AGE between 20 and 29