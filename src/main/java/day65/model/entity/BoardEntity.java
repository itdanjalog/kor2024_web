package day65.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "board")
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno; // 게시물번호
    @Column( columnDefinition = "varchar(100)" , nullable = false )
    private String btitle; // 게시물제목
    @Column( columnDefinition = "longtext")
    private String bcontent; // 게시물내용

    // 단방향
    @ManyToOne // FK
    @JoinColumn( name = "mno") // FK 필드명
    private MemberEntity memberEntity;
}
