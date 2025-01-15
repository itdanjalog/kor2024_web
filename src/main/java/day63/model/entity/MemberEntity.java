package day63.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 현재 클래스를 데이터베이스의 테이블과 매핑 정의
@Table(name = "member")  // 테이블 이름 정의
@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class MemberEntity {
    // ======= 테이블 필드/속성 설계  day59 회원테이블과 비교 =========//
    @Id // primary key 제약조건  정의
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment 제약조건 정의
    private int mno; // 회원번호

    @Column( columnDefinition = "varchar(30)" ,
            nullable = false , unique = true  )
    private String mid; // 회원아이디( not null , unique 제약조건 )

    @Column( columnDefinition = "varchar(20)" , nullable = false )
    private String mpwd; // 회원비밀번호( not null 제약조건 )

    @Column( columnDefinition = "varchar(10)" , nullable = false )
    private String mname; // 회원닉네임( not null 제약조건 )

    @Column( columnDefinition = "varchar(13)" ,
            nullable = false , unique = true )
    private String mphone; // 회원전화번호( not null , unique 제약조건 )

}

/**

 create table member(
 mno int auto_increment ,          # 회원번호
 mid varchar(30) ,                # 회원아이디
 mpwd varchar(20) ,                # 회원비밀번호
 mname varchar(10) ,             # 회원닉네임
 mphone varchar(13) ,            # 회원전화번호
 primary key( mno )               # 회원번호 PK 설정
 );

 */

