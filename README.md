> # ✏ SpringStudy
>
> ### servlet-context.xml
>
> <**resources mapping**="/resources/**" location="/resources/" /> <br>
> <**resources mapping**="/css/**" location="/resources/css/" /> <br>
>
> - /css/abc.css 라는 클라이언트의 요청이 들어오면 이것을 /resources/css/abc.css로 매핑시켜준다. <br>
> - 즉, mapping으로 들어온 요청에 대해 location으로 매핑을 시켜주는 것이다. <br>
> 
> ### **DataSource란?**
>
> - DB와 관계된 커넥션 정보를 담고있으며 빈으로 등록하여 인자로 넘겨준다. → 이 과정을 통해 Spring은 DataSource로 DB와의 연결을 획득한다.
>    - DB 서버와의 연결을 해준다.
>    - DB Connetion pooling기능
> - 종류 : JDBC Driver vendor(MySQL, Oracle)별로 여러가지가 존재한다.
>
> ### DataSource를 설정하고 빈에등록, 주입하는 방법
>
> 1. DB와의 연결을 위해 **DB서버 정보(Property)**를 설정한다. (하드코딩을 피하기위해 파일로 설정 → 이곳에서만 수정하면 다른 모든부분에 변경내용이 적용되므로 이렇게 하는것이 좋다.)
> 2. 설정한 property file을 통해 **DataSource를 빈으로 등록**한다.
>   1. Spring JDBC를 이용하려면 DB 커넥션을 가져오는 DataSource를 빈으로 먼저 등록해줘야함!!
> 3. 생성된 DataSource빈을 **Spring JDBC에 주입**한다.
>
> ### DB Connection Pooling이란?
>
> - 자바 프로그램에서 데이터베이스 연결(커넥션 객체를 얻는것)은 오래걸림
> - **일정량의 Connection객체를 미리 만들어 저장해두었다가 요청시 꺼내쓴다!**
> - 속도와 퍼포먼스가 좋아짐
> - 커넥션풀을 관리하고, 커넥션객체를 풀에서 꺼냈다 반납하는 이러한 과정을 DataSource가 하는것!
>
> ## **JDBC란?**
>
> - DB에 접근할수 있도록 Java에서 제공하는 API (Java Database Connectivity)
> 
>
> 즉, 데이터베이스에서 자료를 쿼리하거나 업데이트하는 방법을 제공한다.
>
> JDBC를 이용하면 데이터베이스에 비 종속적인 DB연동로직을 구현할 수 있다. 즉 mysql을 쓰다가 postgre로 얼마든지 옮길 수 있다는건데 이는 jdbc api가 여러 DB Driver를 호환할 수 있는 인터페이스를 제공하기 때문이다.
>
> ### Plain JDBC의 문제점
>
> - 쿼리를 실행하기 전과 후에 많은 코드를 작성해야한다. (연결생성, 명령문, 등등)
> - 예외처리코드와 트랜잭션 처리등에 시간과 자원이 소모
>    - jdbc에서 발생하는 에러는 Runtime Exception이다. 따라서 모두 예외처리를 해줘야함
> - 이러한 문제점을 보완하여 생겨난것이 Spring JDBC
>
> ## **Spring JDBC란?**
>
> - JDBC의 단점을 보완하여 더 편리한 기능을 제공
> 
>
> ### Spring JDBC가 하는일
>
> - Connection 열기와 닫기
> - Statement 준비와 닫기
> - Statement 실행
> - ResultSet Loop처리
> - Exception 처리와 반환
> - Transaction 처리
> 
> ### Spring JDBC에서 개발자가 할 일
> 
> 핵심적으로 해야될 작업만 해주면 나머지는 Framwork가 알아서 처리해준다.
>
> - datasource 설정
> - sql문 작성
> - 결과 처리
>
> ## SqlSessionFactory
>
> SqlSessionFactory는 데이터베이스와의 연결과 SQL의 실행에 대한 모든 것을 가진 가장 중요한 객체다.이 객체가 DataSource를 참조하여 MyBatis와 Mysql 서버를 연동시켜준다.
>
> ## SqlSessionTemplate
>
> SqlSessionTemplate은 Mybatis 쿼리문을 수행해주는 역할을 합니다.
> ## Bean 등록
>
> context.xml에 context:component-scan으로 의존성을 주입할 경로를 잡아주고 @component, @service, @controller 등 어노테이션을 클래스 상위에 선언해야지 빈객체로 등록이 된다. 그래야 @Autowired(의존성 주입)를 쓸 수 있다.
>
> ```xml
> <context:component-scan base-package="com.project.test.service"></context:component-scan>
> <context:component-scan base-package="com.project.test.vo"></context:component-scan>
> ```
>
> ```java
> @Component
> @NoArgsConstructor(access = AccessLevel.PROTECTED)
> @Setter
> @Getter
> public class MemberVO {
>	private String mem_id;
>	private String mem_pw;
> )
> ```
>
> ## Mapper 등록
>
> mapper는 bean과 다르게 mapper인터페이스에 어노테이션을 해줄 필요가 없다. 대신 namespace로 mapper를 지정해줘야지 해당 mapper를 찾아간다. 그리고 <mybatis-spring:scan base-package= “”>가 mapper의 빈 등록 방법이다.
>
> ```java
> @Autowired
>	LoginMapper log_mapper;
> -----------------------------------------------------------------------------
> public interface LoginMapper {
>	public List<MemberVO> select_mem(String mem_id);
>
> }
> -----------------------------------------------------------------------------
> <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" > "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
> <mapper namespace="com.project.testC.mappers.LoginMapper">
> 
> <!-- XML Mapper에서 namespace는 mapper들을 구분하는 식별자로 매우 중요합니다.
>    클래스에서는 패키지와 같은 역할로 MyBatis 내에서 원하는 SQL문을 찾아서 실행할 때 
> 동작합니다. -->
> -----------------------------------------------------------------------------
> <mybatis-spring:scan base-package="com.project.testC.mappers"/>
> ```
>  
> ## jsp에서 넘어오는 데이터 controller로 받아오기
>
> ```html
> <form action="${contextPath }/member_info" method="POST">
>	<input type="text" name="mem_id" placeholder="이메일을 입력하세요.">
>	<input type="password" name="mem_pw" placeholder="비밀번호를 6자 이상 입력해주세요.">
>	<button class="btn btn-success" type="submit" id="submit">회원가입</button>
> </form>
> ```
>
> ```java
> @Component
> @NoArgsConstructor(access = AccessLevel.PROTECTED)
> @Setter
> @Getter
> public class MemberVO {
>	private String mem_id;
>	private String mem_pw;
>	private String mem_repw;	
>
> }
>
> @RequestMapping("/member_info")
>	public void info_register(MemberVO mem) {
>		System.out.println(mem.getMem_id());
>		System.out.println(mem.getMem_pw());
>		
>	}
> ```
>
> **input name과 memberVO 변수 이름을 일치시킨다. 그리고 controller에서 memberVO로 매개 변수를 받으면 name과 memberVO 변수 명이 일치하기 때문에 데이터가 알아서 들어가게 된다.**
>
