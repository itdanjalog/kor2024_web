package day65task.model.entity;

import day65task.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class MemberEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno; // 회원번호

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String mid; //회원아이디

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String mpwd; // 회원 비밀번호

    @Column(columnDefinition = "varchar(13)")
    private String mphone; // 회원 전화번호

    // entity --> dto로 변환

    public MemberDto toMemberDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd) // 패스워드는 보안상 생략 필요함.
                .mcdate(this.getCdate().toString())
                .mudate(this.getUdate().toString())
                .build();
    } // toMemberDto end

    // 회원 한 명은 여러 주문을 가질 수 있음
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();



}// class end
