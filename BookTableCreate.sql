CREATE TABLE Book_table
(  ISBN      NUMBER           NOT NULL,
    Book_Title    VARCHAR2(100)    NOT NULL,
    Book_Author      VARCHAR2(20)     NOT    NULL,
    Year_Of_Publication         NUMBER(10)               NULL,
    Publisher   VARCHAR2(30)               NULL,
    Image_URL_S        VARCHAR2(500)        NULL,
     Image_URL_M       VARCHAR2(500)        NULL,
      Image_URL_L        VARCHAR2(500)        NULL,
    PRIMARY KEY (ISBN)                  );
    
    select Book_Title 
    from Book_table;
