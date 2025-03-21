🌱 Spring Boot 기본 기능 정리

📌 2-01 스프링부트의 구조 이해

🔹 프로젝트 폴더 구조

📁 src/main/java: 자바 파일을 저장하는 공간

📂 com.mysite.sbb: sbb 프로젝트의 자바 파일을 저장하는 공간으로, 컨트롤러, 폼, DTO, 엔티티 등이 포함됨

🚀 SbbApplication.java: 프로젝트의 시작을 담당하는 파일로, @SpringBootApplication 애너테이션이 적용되어 있어야 함

📁 src/main/resources: 자바 파일을 제외한 HTML, CSS, JS, 환경 파일 등을 저장하는 공간

📂 templates: 자바 객체를 HTML 형태로 출력할 수 있는 템플릿 파일 저장 (Thymeleaf 사용 가능)

📂 static: CSS, JS, 이미지 파일 등을 저장

⚙ application.properties: 프로젝트의 환경 설정 및 데이터베이스 설정을 저장

📁 src/test/java: 작성한 파일을 테스트하는 코드를 저장하는 공간으로, JUnit과 Spring Boot의 테스트 도구를 사용하여 테스트 가능

⚙ build.gradle: Gradle이 사용하는 환경 파일

📌 2-02 간단한 웹 프로그램 만들기

🚨 오류 코드 이해

❌ 오류 404: 브라우저가 요청한 페이지를 찾을 수 없음

💡 클라이언트의 페이지 요청 흐름:
1️⃣ 클라이언트가 페이지 요청
2️⃣ 컨트롤러에서 URL 매핑 찾기
3️⃣ 매핑된 메서드 실행

⚠ 오류 500: 메서드가 호출되었지만 반환값이 없어 발생하는 오류

📌 2-03 JPA로 데이터베이스 사용하기

🛠 ORM과 JPA

🔗 ORM(Object-Relational Mapping): SQL 없이 데이터베이스를 관리할 수 있는 도구

📌 JPA(Java Persistence API): ORM을 위한 인터페이스 모음

🔹 Hibernate: JPA의 인터페이스를 구현한 ORM 프레임워크로, Spring Boot에서 데이터베이스 관리를 쉽게 도와줌

✅ JPA + Hibernate 조합으로 사용됨

📌 2-04 엔티티로 테이블 매핑하기

📄 엔티티(Entity) 개념

📌 엔티티(Entity): 테이블과 매핑되는 자바 클래스

🏷 @Entity: 해당 클래스를 엔티티로 인식

🔑 @Id: 기본 키(PK) 지정

🔢 @GeneratedValue: 자동으로 1씩 증가하는 기본 키 생성

📋 @Column: 열(Column)의 세부 설정 가능

📏 length: 문자열 길이 지정

🔠 columnDefinition: 글자 수 제한이 없는 경우 사용

📝 네이밍 컨벤션

엔티티 속성명 → 소문자로 변환 후 언더바(_) 추가하여 데이터베이스의 열 이름으로 변경됨

예) createDate → create_date

⚠ 엔티티에서 Setter 사용 지양

엔티티는 DB와 바로 연결되므로 데이터 변경을 최소화하기 위해 Setter 사용을 지양

대신 생성자를 통해 값을 저장하고, 데이터를 변경할 때는 별도의 메서드를 추가로 작성

🔗 관계 설정

@ManyToOne: 여러 개의 엔티티가 하나의 엔티티와 관계를 맺을 때 사용 (부모-자식 관계)

@OneToMany: 1:N 관계에서 사용

mappedBy: 참조 엔티티의 속성명을 정의하며, 참조된 속성을 mappedBy에 전달해야 함
