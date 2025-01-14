package day62.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity// 1. 해당 클래스를 DB의 테이블과 매핑 정의한다.
@Table( name = "board")// 1. 해당 엔티티와 매핑된 테이블의 이름 정의한다.
// 롬복 어노테이션
@Getter // private 멤버변수를 접근 get메소드 생성 한다.
@Setter // private 멤버변수를 접근 set메소드 생성 한다.
@ToString // toString 메소드 : 객체 출력시 멤버변수의 값 반환함수.
@Builder // 객체 생성시 생성자가 아닌 유연하게 객체를 만들기 위한 (빌더) 패턴 지원
@NoArgsConstructor@AllArgsConstructor // 빈생성자/모든매개변수생성자
public class BoardEntity {
    @Id
    // 1. 해당 필드/속성의 제약조건에 primary key 정의하는 어노테이션.
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    // 1. mysql의 auto_increment의 제약조건과 동일한 어노테이션
    private int bno;
    @Column( columnDefinition = "varchar(100)" , nullable = false )
    // 1. 해당 필드/속성의 타입,제약조건 정의하는 어노테이션
    private String btitle;

    @Column( columnDefinition = "longtext" , nullable = false )
    private String bcontent ;

    @Column( columnDefinition = "varchar(30)" , nullable = false )
    private String bwriter;

    @Column( columnDefinition = "varchar(30)" , nullable = false )
    private String bpwd;
}
