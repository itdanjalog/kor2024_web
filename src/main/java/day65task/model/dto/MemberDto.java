package day65task.model.dto;

import day65task.model.entity.MemberEntity;
import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class MemberDto {

    private int mno;
    private String mid;
    private String mpwd;
    private String mphone;
    private String mcdate; // 회원가입 날짜
    private String mudate; // 회원정보 수정날짜

    // dto--> entity
    public MemberEntity toMemberEntity() {
        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .mphone(this.mphone)
                .build();
    }
}
