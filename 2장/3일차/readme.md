2-05 리포지토리로 데이터베이스 관리하기

엔티티: 데이터베이스 테이블 생성
리포지토리: 생성된 데이터베이스 테이블을 저장,조회,수정,삭제 등을 할 수 있도록 도와주는 인터페이스/ 테이블에 접근하고, 데이터를 관리하는 메서드를 제공한다.

#QuestionRepositry 인터페이스 생성
package com.mysite.sbb;
[Uploading SbbApplicationTests.java…]()

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
QuestionRepository 인터페이스를 레포지토리로 만들기 위해 JpaRepository 인터페이스를 상속한다. 
JpaRepository 인터페이스는 JPA가 제공하는 인터페이스 중 하나로, CRUD 작업을 처리하는 메서드를 이미 포함하고 있어 데이터 관리 작업을 좀 더 편리하게 처리할 수 있도록 한다.
JpaRepository<Question, Integer>는 Question엔티티로 레포지토리를 생성한다는 의미이며, 기본키가 Integer임을 이와 같이 추가로 지정해야 한다. 

@Autowired: 질문 엔티티의 데이터를 생성할 때 리포지터리가 필요하므로, 이를 통해 스프링의 의존성 주입이라는 기능을 사용하여 QuestionRepository의 객체를 주입했다.
테스트 코드의 경우 Junit이 생성자를 통한 객체 주입을 지원하지 않으므로, 텍스트 코드 작성 시에만 @Autowired를 사용하고 실제로는 생성자를 통한 객체 주입 방식을 사용한다.
스프링의 의존성 주입: 스프링이 객체를 대신 생성하여 주입하는 기법이다.

@Test:testJpa메서드가 테스트 메서드임을 나타낸다.

findAll메서드: 테이블에 저장된 모든 데이터를 조회하기 위해 사용한다.
assertEquals: 예상한 결과와 실제 결과가 동일한지를 확인하는 목적으로 사용. JPA 또는 데이터베이스에서 데이터를 올바르게 가져오는지를 확인
Optioanl: 존재할 수도 있고, 존재하지 않을 수도 있을 경우 리턴타입으로 사용
isPresent: 값이 존재하는지 확인

"findBy + 엔티티의속성명"과 같은 리포지토리의 메서드를 작성하면 입력한 속성의 값으로 데이터를 조회할 수 있다.
응답 결과가 여러건인 경우에는 레포지토리의 메서드의 리턴타입을 Question이 아닌 List<Question>으로 작성해야 한다.

findBySubjectLike: subject 열 값들 중에 특정 문자열을 포함하는 데이터를 조회한다.
repository의 count메서드는 테이블 행의 개수를 리턴한다.(~96p)
