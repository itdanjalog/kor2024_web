package day64.JPA연관관계.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "board")
@DynamicInsert // @ColumnDefault 어노테이션 사용하기 위해서 사용되는 어노테이션
public class BoardEntity extends BaseTime {
    @Id //pk
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int bno; // 게시물번호

    @Column( columnDefinition = "varchar(100)" , nullable = false )
    private String btitle; // 게시물제목

    @Column( columnDefinition = "longtext" )
    private String bcontent; // 게시물내용

    @Column( columnDefinition = "int")
    @ColumnDefault( "0" ) // 엔티티 생성시 default 값을 초기화 하는 어노테이션
    private int bview; // 게시물 조회수

    // 단방향
    @ManyToOne // 다수가 하나에게 , M : 1 , 다수(FK)가 하나(PK) // FK 제약조건 정의
    @JoinColumn( name="mno") // FK필드의 이름 정의
    private MemberEntity memberEntity;

}
