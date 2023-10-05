# Minination

## 목차

1. [서비스 소개](#-1-서비스-소개)
2. [진행 기간](#-2-진행-기간)
3. [주요 기능](#-3-주요-기능)
4. [구성원](#-4-구성원)
5. [시스템 아키텍쳐](#-5-시스템-아키텍쳐)
6. [기술 스택](#-6-기술-스택)
7. [ER Diagram](#-7-er-diagram)
8. [Sequence Diagram](#-8-sequence-diagram)
9. [협업툴](#-9-협업툴)
10. [API 명세서](#-10-API-명세서)
11. [코드 컨벤션](#-11-코드-컨벤션)
12. [커밋 컨벤션](#-12-커밋-컨벤션)
13. [Git Flow 브랜치 전략](#-13-git-flow-브랜치-전략)

## 💸 1. 서비스 소개

<img src="./img/main_image.png">

교실 속 우리들의 작은 국가, Minination!

Minination은 초등학생을 위한 체험형 경제교육 플랫폼 서비스입니다.


## 💸 2. 진행 기간

2023.08.21 ~ 2023.10.06 (7주)

## 💸 3. 주요 기능

### 1. 국가 생성, 국적 취득

<img src="./img/foundation.png" width=800px> 

- 선생님이 국가명, 세율, 헌법 등 시뮬레이션 환경을 세팅합니다.
- 학생들은 Minination에 회원가입한 후, 국가 검색을 통해 자신의 반 선생님이 세팅해둔 국가의 국적을 취득할 수 있습니다.

### 2. 홈화면

<img src="./img/home.png" width=800px>

- 본인이 속한 국가의 메인 화면입니다.  
- 국가명, 국기, 본인의 프로필, 국가에서 가장 많은 돈을 보유한 학생의 순위, 국가의 경제발전 그래프, 헌법, 구성원 등 다양한 정보를 확인할 수 있습니다.

### 3. 직업 생성, 구직 활동

<img src="./img/job.png" width=800px> 

- 선생님은 각 학급에 필요한 다양한 역할을 직업 생성 기능을 통해 정해줍니다.
  - (ex) 방역요원 : 점심 시간에 친구들의 책상 위를 소독해요. / 주급 : 50만원. / 모집인원 : 2명
- 여기서 주급으로 받게 되는 화폐는 가상의 돈이며 선생님이 국가 생성 시 설정해둔 주급 수령일에 학생의 계좌로 학급 화폐가 자동 이체 됩니다.
- 학생은 채용공고 게시판에서 직업 설명, 주급, 자격요건 등을 보고 원하는 직업을 지원할 수 있습니다.
- 선생님은 지원한 학생들 중 해당 직업에 적합한 인원에게 직업 지원을 승인해주고, 그렇지 않은 인원에겐 거절할 수 있습니다. 

### 4. 주식 투자

<img src="./img/stock.png" width=800px> 

- 초등학생에게 익숙한 기업 중 5개를 선정하여 실제 기업의 주가를 받아옵니다. 
  - 삼성전자, 현대자동차, 넥슨게임즈, 하이브, 카카오
- 학생들은 증권거래소 게시판에서 각 회사의 광고, 기업 설명, 기업정보 등을 확인할 수 있습니다. 또한 회사 주가의 최근 1달 동안의 주가 추이를 그래프로 확인할 수 있습니다. 
- 학급 화폐를 통해 실제 주가와 동일한 가격에 원하는 회사의 주식을 매수, 매도할 수 있습니다. 

### 5. 은행 업무

<img src="./img/bank.png" width=800px> 

- 학생들은 은행 게시판에서 본인의 현금/주식/저축 자산과 1달 동안 본인의 자산 변동 현황을 확인할 수 있습니다.
- 자산 변동 현황의 세부 항목은 '입출금 내역조회'에서 입출금처/금액/잔액/날짜를 확인할 수 있습니다.
- '금융상품 가입'에서 예금과 적금 상품에 가입할 수 있습니다. 만기일이 되면 각 상품의 이자율에 맞는 금액을 더해서 돌려받습니다.
- '가입한 상품조회'에서 본인이 가입한 예금, 적금 상품의 가입일과 만기일, 원금과 만기 예상금액을 확인할 수 있습니다. 또한 학생이 원한다면 해당 상품을 해지하고 즉시 원금을 돌려받을 수 있습니다.

### 6. 소비

<img src="./img/market.png" width=800px>

- 백화점 게시판에서 선생님은 학생들이 구입할 수 있는 상품을 상품명/상품설명/가격과 함께 등록할 수 있습니다. 
  - (ex) 상품명 : 헌책방, 상품설명 : 	교과서를 가져오지 않은 경우 한 시간 빌려드립니다!, 가격 : 300000
- 학생들은 선생님이 등록한 상품을 구매할 수 있는 물품 목록에서 확인하고, 원하는 상품을 원하는 수량만큼 구매할 수 있습니다.
- '내가 구매한 물품'에서 본인이 구입한 물품의 설명, 수량을 확인하고 사용을 원하는 경우 사용하기 버튼을 통해 해당 상품을 소비할 수 있습니다. 

### 7. 집무실

<img src="./img/admin.png" width=800px> 

- 집무실 게시판은 선생님만 상단 메뉴를 통해 접근할 수 있는 게시판입니다.
- 국가명, 화폐명, 주급 수령일, 소득세, 부가가치세를 조회하고 설정할 수 있습니다.


## 💸 4. 구성원

<img src="./img/member_image.png" width=800px> 


## 💸 5. 시스템 아키텍쳐

<img src="./img/architecture.png" width=800px>

## 💸 6. 기술 스택

### 1. Front

<img src="https://img.shields.io/badge/React-403C42?style=for-the-badge&logo=React&logoColor=white">
<img src="https://img.shields.io/badge/Recoil-403C42?style=for-the-badge&logo=Recoil&logoColor=white">
<img src="https://img.shields.io/badge/Node.js-403C42?style=for-the-badge&logo=Node.js&logoColor=white">
<img src="https://img.shields.io/badge/javascript-403C42?style=for-the-badge&logo=javascript&logoColor=white">


- React로 사용자와의 상호작용이 많은 웹 페이지를 효율적으로 구현하고 관리하였습니다.
- Recoil을 이용해 API 응답 데이터를 캐싱함으로써 서버 통신 비용을 줄였습니다.


### 2. Back

<img src="https://img.shields.io/badge/Spring Boot 3.1.1-403C42?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/JPA-403C42?style=for-the-badge&logo=jpa&logoColor=white">
<img src="https://img.shields.io/badge/Query Dsl-403C42?style=for-the-badge&logo=Query Dsl&logoColor=white">
<img src="https://img.shields.io/badge/java 17-403C42?style=for-the-badge&logo=java&logoColor=white">

<img src="https://img.shields.io/badge/spring security-403C42?style=for-the-badge&logo=springsecurity&logoColor=white">
<img src="https://img.shields.io/badge/nginx-403C42?style=for-the-badge&logo=nginx&logoColor=white">
<img src="https://img.shields.io/badge/amazon ec2-403C42?style=for-the-badge&logo=amazonec2&logoColor=white">

- Springboot로 웹 어플리케이션 서버를 구축하였습니다.
- Spring Data JPA(Hibernate) 로 객체 지향 데이터 로직을 작성하였습니다.
- QueryDSL 로 컴파일 시점에 SQL 오류를 감지하고, 더 가독성 높은 코드를 작성하였습니다.
- AWS EC2를 이용해 서버를 배포하였습니다.

### 3. DB

<img src="https://img.shields.io/badge/MariaDB-403C42?style=for-the-badge&logo=MariaDB&logoColor=white">
<img src="https://img.shields.io/badge/Redis-403C42?style=for-the-badge&logo=Redis&logoColor=white">
<img src="https://img.shields.io/badge/Firebase-403C42?style=for-the-badge&logo=Firebase&logoColor=white">

- MariaDB로 RDBMS 기반의 데이터 설계를 하였습니다.
- Redis로 이메일 인증코드를 캐싱하고 유효 시간을 제한하여 속도를 개선하고 보안을 강화하였습니다.
- Firebase Cloud Storage를 통해 이미지(별자리, 프로필, 게시글), 동영상 등 파일을 업로드합니다.
- Firebase RealTime Database를 통해 메세지와 초대 알림을 저장합니다.

## 💸 7. ER Diagram

<img src="./img/ERD.png" width=800px>

## 💸 8. Sequence Diagram



## 💸 9. API 명세서

https://pyh-dotcom.notion.site/API-ee059890d8e94b3eac93dee50af9810d?pvs=4

## 💸 10. 협업툴

- Gitlab
- Jira
- Notion
- Mattermost

## 💸 11. 코드 컨벤션

### 1. Front

# 들여쓰기

- ****space와 tab을 섞어서 사용하지 않는다.****
- 공백 문자 2개

# 문장의 종료

- 한 줄에 하나의 문장만 허용하며, 문장 종료 시에는 **반드시 세미콜론(;)을 사용한다.**

# 명명 규칙

- 변수는 ****`카멜 케이스`을 사용한다.**
- ****[예약어](http://es5.github.io/#x7.6.1)를 사용하지 않는다.**
- ****상수****는 영문 대문자 스네이크 표기법(Snake case)를 사용한다.
    - `SYMBOLIC_CONSTANTS;`
- ****생성자****는 대문자 카멜 케이스을 사용한다.
    
- ****변수, 함수****에는 카멜 케이스을 사용한다. (컴포넌트는 파스칼 케이스를 사용한다.)
- ****URL, HTML 같은 범용적인 대문자 약어****도 대문자 카멜 케이스를 적용한다.
    - `Url, Html, Api`
- **이벤트 핸들러**는 `on` 으로 시작한다.
- **이미지** 파일명은 케밥케이스를 사용한다. (sample-image.png)
- **축약어**는 사용하지 않는다 (img → image)

# ****선언과 할당****

## ****변수****

- 값이 변하지 않는 변수는 `const`를, 값이 변하는 변수는 `let`을 사용하여 선언한다. `var`는 절대로 사용하지 않도록 한다.
- **const**를 let 보다 **위에** 선언한다.
- const와 let은 **사용 시점에 선언 및 할당**을 한다.
- 외부 모듈과 내부 모듈을 구분하여 사용한다.
- 자기 참조 할당은 하지 않는다.
- `var` 사용 시 반드시 함수 스코프의 시작 지점에서 선언한다. `(ES5)`

## 배열과 객체

- 배열과 객체는 반드시 **리터럴**로 선언한다.
    
- **배열 복사** 시 for 순환문을 사용하지 않는다.
    - 깊은 복사 (변경사항이 원본에 반영 X)
        
- 배열에 어떤 **요소를 추가**할 때 push()를 사용하지 않는다.
    - .concat()을 이용해 원본 배열의 불변성을 해치지 않고 요소를 추가한다.
        
- **객체의 프로퍼티**가 1개인 경우에만 한 줄 정의를 허용하며, **2개 이상**일 경우에는 **개행**을 강제한다.

- 객체 리터럴 정의 시 **콜론 앞은 공백을 허용하지 않으며 콜론 뒤는 항상 공백을 강제한다.**
    
- ****객체의 메서드 표현 시 `축약 메소드 표기`를 사용한다.**

- ****`메서드 문법` 사용 시 메서드 사이에 개행을 추가한다.**
    

## 함수

- ****함수 생성자를 사용하여 선언하지 않는다.****
- 함수 표현식 대신 **화살표 함수**를 사용한다.
    
- ****화살표 함수의 파라미터가 하나이면 괄호를 생략한다.****
  
    
- ****암시적 반환을 최대한 활용한다.****
    - 함수의 본체가 하나의 표현식이면 중괄호를 생략하고 암시적 반환을 사용할 수 있다. 그 외에는 `return`문을 명시해야 한다.

- ****암시적 반환을 사용할 경우 함수 본문 전에 개행을 하지 않는다.****
    
    

## 구조분해할당 (****Destructuring)****

- ****오브젝트의 프로퍼티에 접근할 때는 Destructuring을 이용한다.****

### 2. Back

- 변수명은 camelCase를 사용하고 명사로 명명합니다.
- 함수명은 camelCase를 사용하고 동사로 명명합니다.
- 클래스 명은 UpperCase를 사용하고 명사로 명명합니다. 
  - (ex) Member
- 클래스 선언, 메서드 선언, 조건/반복문의 시작 중괄호`{`는 선언부와 같은 줄에 사용합니다.
- 함수의 행 길이는 25줄 이하로 작성하는 것을 지향합니다.
- 배열 선언시 대괄호`[]` 는 타입 옆에 지정합니다. 예: String[] args (O), String args[] (X)
- 약어는 camelCase를 사용합니다. 예: urlApi (O), URL API(X)
- DTO 클래스는 요청은 xxxRequest, 응답은 xxxResponse로 명명합니다.
- LocalDateTime 타입의 변수는 xxxAt으로 네이밍합니다.

## 💸 12. 커밋 컨벤션

- feat: 새로운 기능 구현
- fix: 오류 수정
- docs: readme.md, json 파일 등 수정, 라이브러리 설치 (문서 관련)
- refactor: 코드 리팩토링
- style: 코드에 변화가 없는 수정 (세미콜론 등)
- chore: 빌드 부분 혹은 패키지 매니저 수정 사항
- rename: 파일 혹은 폴더명 수정, 옮기기
- remove: 파일 삭제
- ci: 배포 관련 작업

## 💸 13. Git Flow 브랜치 전략

- master
- fe
    - fe/dev (배포)
    - +
    - fe/member/login
    - fe/bank/checkAccount
- be
    - be/dev (배포)
    - be/member
        - be/member/login/S09A508-33
    - be/bank
        - be/bank/checkAccount