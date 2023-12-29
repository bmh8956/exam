package m_board;

import lombok.Data;

import java.sql.Date;

@Data
public class M_boardDTO {
    private int id;
    private String m_title;
    private String m_write;
    private String m_cont;
    private Date regdate;
    private int cnt;
}
