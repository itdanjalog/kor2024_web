package day64.JPA연관관계.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "reply")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class ReplyEntity {

    @Id //pk
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private  int rno; // 게시물번호

    @Column( columnDefinition = "varchar(255)" , nullable = false )
    private  String rcontent; // 댓글내용

    // 단향향 FK : 게시물(pk) --- 댓글[fk]
    @ManyToOne
    @JoinColumn( name  = "bno")
    private  BoardEntity boardEntity;

    // 단방향 FK : 회원(ㅒpk) ---> 댓글[fk]
    @ManyToOne
    @JoinColumn( name = "mno")
    private MemberEntity memberEntity;

}
