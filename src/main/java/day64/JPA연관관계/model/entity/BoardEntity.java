package day64.JPA연관관계.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@DynamicInsert // @ColumnDefault 어노테이션 사용하기 위해서 사용되는 어노테이션
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class BoardEntity extends BaseTime {
    @Id //pk
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int bno; // 게시물번호

    @Column(columnDefinition="varchar(100)", nullable = false )
    private String btitle; // 게시물제목

    @Column( columnDefinition = "longtext" )
    private String bcontent; // 게시물내용

    @Column( columnDefinition = "int")
    @ColumnDefault( "0" ) // 엔티티 생성시 default 값을 초기화 하는 어노테이션
    private int bview; // 게시물 조회수

    // 단방향 FK
    @ManyToOne // 다수가 하나에게 , M : 1 , 다수(FK)가 하나(PK) // FK 제약조건 정의
    @JoinColumn( name="mno") // FK필드의 이름 정의
    private MemberEntity memberEntity;

    // 양방향      // board가 삭제/수정/저장 되면 reply도 같이 삭제/수정/저장 , .getReply() 할때 댓글 데이터를 가져온다.(지연로딩)
    @OneToMany( mappedBy = "boardEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @ToString.Exclude @Builder.Default
    List< ReplyEntity> replyEntityList = new ArrayList<>();
}
/*
    - 영속성 제약조건 ( cascade , fetch ) : PK와 FK 필드 관계 옵션
        @OneToMany( cascade = CascadeType.XXX ) : 서로 연관된 객체들 간의 영향을 주는 방법 설정
        1. cascade = CascadeType.ALL           : 부모[PK] 가 삭제/수정 되면 자식[FK] 도 같이 삭제/수정        , REMOVE+MERGE+PERSIST
        2. cascade = CascadeType.REMOVE        : 부모[PK] 가 삭제 되면 자식[FK] 도 같이 삭제
        3. cascade = CascadeType.MERGE         : 부모[PK] 가 수정 되면 자식[FK] 도 같이 수정
        4. cascade = CascadeType.PERSIST       : 부모[PK] 가 저장 될때 참조하는 자식[FK] 도 같이 저장된다.
        5. cascade = CascadeType.REFRESH       : 부모[PK] 가 수정되면 자동으로 자식[FK] 값도 다시 불러온다.[새로고침]
        6. cascade = CascadeType.DETACH        : 영속성(연관관계) 제거

    - fetch : 양방향일때 참조되는 엔티티 불러오는 로딩 방식
        1. fetch = FetchType.EAGER              : 즉시 로딩(기본값) , find 함수 사용할때 참조되는 모든 객체를 불러온다.
            특징 : 연관된 엔티티를 즉시 모두 불러온다.
            단점 : 불필요한 엔티티가 가져올 수 있다.
        2. fetch = FetchType.LAZY               : 지연 로딩        , getXXX 할때 참조 객체를 불러온다. ( 메모리 효율적이다 )
            특징 : 연관된 엔티티를 호출할 때( .getXXX ) 데이터를 불러온다.
            장점 : 초기 로딩 시 빠르다.
 */










