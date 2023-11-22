SELECT *
FROM (
    SELECT 
        CASE 
            WHEN m_id = :id AND m_pw = :pw THEN 1
            WHEN m_id = :id AND m_pw <> :pw THEN 0
            ELSE -1
        END AS login_status
    FROM member1
    WHERE rownum =1
) login_result;

-- id와 pw 파라미터를 입력, 그것이 첫 번째 열의 아이디와 같을 경우 0, 패스워드도 같으면 1, 아이디가 틀리면 -1을 도출핢
