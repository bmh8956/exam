package member;

import lombok.Data;

@Data
public class MemberDTO {
    private String id;
    private String password;
    private String phone;
    private String email;
    private String regdate;
    private String addr;
    private String role;
}
