package day63.model.entity;

import day63.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity // 현재 클래스를 데이터베이스의 테이블과 매핑 정의
@Table(name = "member")  // 테이블 이름 정의
@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class MemberEntity extends BaseTime   {
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

    // entity --> Dto 변환 메소드 ( 롬복 제공 하지 않음 )
    public MemberDto toDto(){
        // + 빌더패턴 이용한 인스턴스 생성
        // 클래스명.builder().멤버변수명(새로운값).build();
        return MemberDto.builder() // .builder() 빌더패턴의 시작점.
                .mno( this.mno )
                .mid( this.mid )
                // 패스워드는 보안상 생략
                .mname( this.mname )
                .mphone( this.mphone )
                .cdate( this.getCdate().toString() ) // 엔티티 생성날짜 , 가입날짜
                .udate( this.getUdate().toString() ) // 엔티티 수정날짜 , 회원정보수정 날짜.
                .build(); // .build() 빌더패턴의 끝마침.
    } // f end

} // class end

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

