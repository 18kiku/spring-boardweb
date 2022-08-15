# 스프링 게시판 프로젝트

## 1. 개요
### 주제
스프링 프레임워크의 활용법을 익히기 위해 회원용 CRUD 게시판을 구현해본다.
### 이유
스프링 프레임워크 활용법을 익힐 수 있는 가장 기초적인 프로젝트



## 2. 주요 기능
+ 로그인
+ 회원 가입
+ 회원 정보 수정
+ + 회원 탈퇴
+ 게시판 이용
+ 댓글 기능
+ 페이징

## 3. 개발 환경
```
+ OS: Windows 10
+ Java Version: Java SE-1.8 (jre1.8.0_321)
+ IDE: spring-tool-suite-3.9.15.RELEASE-34.16.0
+ DB: Oracle
```


## 4. 요구사항

### 회원 관리

#### 1. 로그인
+ id와 password가 일치여부 확인
+ 일치 시 세션에 회원 정보 저장 후 게시판 목록 페이지로 이동
+ 불일치 시 로그인 페이지로 재 이동

#### 2. 회원가입
+ 아이디, 비밀번호, 이름, 이메일 필수 입력
+ 아이디 중복검사, 이메일 유효성 검사
+ 가입 완료 시 로그인 페이지로 이동

### 게시판 이용
##### *게시물 보기를 제외한 모든 기능은 로그인 시에만 이용 가능

#### 1. 게시글 등록
+ 제목과 내용은 직접 입력, 작성자는 세션에 저장된 아이디

#### 2. 게시글 수정, 삭제
+ 게시글의 작성자와 세션에 저장된 아이디가 같을 경우 버튼 활성화

#### 3. 댓글 등록
+ 내용은 입력, 작성자는 세션에 저장된 아이디
+ 댓글의 작성자와 세션에 저장된 아이디가 같다면 수정, 삭제 버튼 활성화

#### 4. 게시글 검색
+ 제목, 내용, 작성자 세 가지 종류로 검색 가능

#### 5. 페이징 구현
+ 페이지당 n개씩 조회할 수 있도록 쿼리 작성
+ 페이징 블록 이동 버튼 구현(ex. 첫 페이지, 다음 페이지)



## 5. 테이블 정의

테이블ID	BOARD			
순번	컬럼명	타입 및 길이	NULL	PK	FK
1	BOARD_ID	NUMBER	Not Null	Y	　
2	WRITER	VARCHAR2(30)	Not Null	　	Y
3	TITLE	VARCHAR2(100)	Not Null	　	　
4	CONTENT	CLOB	Not Null	　	　
5	CNT	NUMBER	Null	　	　
6	CREATE_DATE	TIMESTAMP(6)	Null	　	　
7	UPDATE_DATE	TIMESTAMP(6)	Null	　	　

테이블ID	COMMENTS			
순번	컬럼ID	타입 및 길이	NULL	PK	FK
1	COMMENT_ID	NUMBER	Not Null	Y	　
2	BOARD_ID	NUMBER	Not Null	　	Y
3	WRITER	VARCHAR2(30)	Not Null	　	Y
4	COMMENTS	CLOB	Not Null	　	　
5	CREATE_DATE	TIMESTAMP(6)	Null	　	　
6	UPDATE_DATE	TIMESTAMP(6)	Null	　	　

테이블ID	MEMBER			
순번	컬럼ID	타입 및 길이	NULL	PK	FK
1	MEMBER_ID	VARCHAR2(30)	Not Null	Y	　
2	PASSWORD	VARCHAR2(30)	Not Null	　	　
3	NAME	VARCHAR2(30)	Not Null	　	　
4	EMAIL	VARCHAR2(50)	Not Null	　	　
5	CREATE_DATE	TIMESTAMP(6)	Null	　	　
6	UPDATE_DATE	TIMESTAMP(6)	Null	　	　

## 6. 화면 구성

#### 1. 로그인
![image](https://user-images.githubusercontent.com/98327681/184592075-ce449443-0a87-4084-a96c-28c17f5c753c.png)


#### 2. 회원가입
![image](https://user-images.githubusercontent.com/98327681/184592084-d6734021-4833-495b-b08a-a3f607afd112.png)


#### 3. 회원정보
![image](https://user-images.githubusercontent.com/98327681/184592102-2247ced8-b256-4687-b77e-4008da798db8.png)


#### 4. 글목록
![image](https://user-images.githubusercontent.com/98327681/184592119-70fdb1c6-d21a-481e-b1c4-340682c08273.png)


#### 5. 글상세
![image](https://user-images.githubusercontent.com/98327681/184592134-aab1665c-f5fe-4728-9968-ba95931c2251.png)


#### 6. 글등록
![image](https://user-images.githubusercontent.com/98327681/184592152-c4a550e9-3843-48c7-b3f3-519395c9503d.png)

