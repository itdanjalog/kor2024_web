package day63.model.dto;

import day63.model.entity.MemberEntity;
import lombok.*;

//롬복
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class MemberDto {
    // + 멤버변수
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String cdate; // 회원 가입 날짜/시간
    private String udate; // 회원 정보 수정 날짜/시간

    // Dto --> entity  ( 롬복 제공 하지 않음 )
    public MemberEntity toEntity(){
        // (방법1) 빌더패턴 : 인스턴스를 생성할때 생성자 보다 유연한 생성 방법 제시.
            // 클래스명.builder().멤버변수명(새로운값).멤버변수명(새로운값).build();
        return MemberEntity.builder()
                .mno( this.mno )
                .mid( this.mid )
                .mpwd( this.mpwd )
                .mname( this.mname )
                .mphone( this.mphone )
                .build();
        // (방법2)생성자
        // return new MemberEntity( this.mno , this.mid , this.mpwd , this.mname , this.mphone );
    }


} // class end

