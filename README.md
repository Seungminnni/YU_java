# YU Java 프로젝트

이 프로젝트는 Java 프로그래밍 학습을 위한 종합 예제 코드들을 포함하고 있습니다.

## 프로젝트 구조

```
YU_java/
├── Practice_01/
│   ├── Hello.java
│   ├── Example01.java
│   ├── Datatype01.java
│   ├── Datatype02.java
│   ├── Datatype03.java
│   ├── Datatype04.java
│   ├── InputOutput01.java
│   ├── InputOutput02.java
│   ├── Operator01.java
│   └── Welcome.java
├── Homework_01/
│   ├── hw1.java
│   ├── hw2.java
│   └── hw3.java
└── README.md
```

## 파일 설명

### Practice_01 패키지 (기본 실습)

#### Hello.java
- 기본적인 Java 프로그램 구조
- 변수 선언과 출력 예제

#### Example01.java
- 상수와 변수의 차이를 보여주는 예제
- `final` 키워드를 사용한 상수 선언
- 변수 값 변경의 예시

#### Datatype01.java
- Java 기본 데이터 타입들을 보여주는 예제
- `int`, `short`, `byte`, `long` 데이터 타입 사용
- 각 데이터 타입의 값 출력 예시

#### Datatype02.java
- Java 실수형 데이터 타입들을 보여주는 예제
- `float`와 `double` 데이터 타입 사용
- 실수 값 출력 예시

#### Datatype03.java
- Java 문자형 데이터 타입을 보여주는 예제
- `char` 데이터 타입 사용
- 문자 값 출력 예시

#### Datatype04.java
- Java 문자열 데이터 타입을 보여주는 예제
- `String` 데이터 타입 사용
- 문자열 연결 연산자 예시

#### InputOutput01.java
- Java 기본 입출력 예제
- `System.out.println()`을 사용한 출력
- 문자열과 변수 연결

#### InputOutput02.java
- Java 이스케이프 시퀀스 사용 예제
- `\t` (탭)과 `\n` (줄바꿈) 활용
- 서식 있는 출력

#### Operator01.java
- Java 산술 연산자 종합 예제
- `+`, `-`, `*`, `/`, `%` 연산자 사용
- `int`와 `double` 간의 자동 형 변환

#### Welcome.java
- 쇼핑몰 시스템 메뉴 화면 구현
- 탭을 사용한 깔끔한 정렬
- 사용자 인터페이스 디자인 예제

### Homework_01 패키지 (숙제 실습)

#### hw1.java
- Java 데이터 타입 종합 실습
- `String`, `int`, `float`, `char`, `boolean` 데이터 타입 모두 사용
- 개인 정보 출력 예제

#### hw2.java
- Java printf 메소드 실습
- 소수점 둘째자리 고정 출력
- 사각형 면적과 둘레 계산

#### hw3.java
- Java Scanner 클래스 실습
- 사용자 입력 처리
- 섭씨 ↔ 화씨 온도 변환

## 학습 내용

### 기본 개념
- Java 기본 문법과 프로그램 구조
- 변수 선언과 초기화
- 패키지 사용법

### 데이터 타입
- Java 기본 데이터 타입 (`int`, `short`, `byte`, `long`)
- Java 실수형 데이터 타입 (`float`, `double`)
- Java 문자형 데이터 타입 (`char`)
- Java 문자열 데이터 타입 (`String`)
- Java 논리형 데이터 타입 (`boolean`)

### 변수와 상수
- 변수와 상수의 차이점
- `final` 키워드 사용법
- 데이터 타입에 따른 메모리 할당

### 입출력
- `System.out.println()`을 사용한 출력
- `System.out.print()`을 사용한 출력
- `System.out.printf()`을 사용한 형식화된 출력
- 이스케이프 시퀀스 (`\t`, `\n`, `\"`, `\\`)
- `Scanner` 클래스를 사용한 사용자 입력

### 연산자
- 산술 연산자 (`+`, `-`, `*`, `/`, `%`)
- 자동 형 변환 (Type Promotion)
- 연산자 우선순위

### 실전 응용
- 온도 변환기 구현
- 계산기 프로그램
- 사용자 인터페이스 디자인
- 메뉴 시스템 구현

## 실행 방법

### 기본 파일 실행
```bash
javac -d . Practice_01/파일명.java
java Practice_01.클래스명
```

### 입력이 필요한 파일 실행
```bash
javac -d . Homework_01/hw3.java
java Homework_01.hw3
# 이후 콘솔에서 값 입력
```

## 요구사항

- Java JDK 8 이상
- 터미널 또는 명령 프롬프트
- 텍스트 에디터 (VS Code 권장)

## 작성자

Seungminnni

---

*이 프로젝트는 Java 초보자를 위한 종합 학습 자료입니다. 각 파일을 순서대로 학습하며 Java의 기초를 탄탄하게 다질 수 있습니다.*
