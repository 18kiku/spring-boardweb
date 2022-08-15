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
+ 회원 탈퇴
+ 게시판 이용
+ 댓글 기능
+ 페이징

## 3. 개발 환경
```
OS: Windows 10
Java Version: Java SE-1.8 (jre1.8.0_321)
IDE: spring-tool-suite-3.9.15.RELEASE-34.16.0
DB: Oracle
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

![member](https://user-images.githubusercontent.com/98327681/184666810-493f930f-42fd-47c2-bbc1-2c6f07a479fc.PNG)


![board](https://user-images.githubusercontent.com/98327681/184666742-01df5902-1053-431c-bb68-bf0c420bdcde.PNG)

![comments](https://user-images.githubusercontent.com/98327681/184666826-6981e883-c43d-46e4-82c6-3836648a88d4.PNG)



## 6. 화면 구성

#### 1. 로그인
![image](https://user-images.githubusercontent.com/98327681/184667196-8d48ee3c-2a57-4318-a2c2-4a0064aecf48.png)


#### 2. 회원가입
![image](https://user-images.githubusercontent.com/98327681/184667286-aa5f9f1b-5a86-4e67-af3e-53672fa9328d.png)


#### 3. 회원정보
![image](https://user-images.githubusercontent.com/98327681/184667343-304ecafc-e1f9-47c3-92f6-cd179a59f5e7.png)


#### 4. 글목록
![image](https://user-images.githubusercontent.com/98327681/184592119-70fdb1c6-d21a-481e-b1c4-340682c08273.png)


#### 5. 글상세
![image](https://user-images.githubusercontent.com/98327681/184667396-787e84a4-df68-4fdc-9d4d-e405027452c9.png)


#### 6. 글등록
![image](https://user-images.githubusercontent.com/98327681/184667437-9f8ce05a-c84d-4aa5-b68f-a3e6ef6d0303.png)


