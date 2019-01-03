package net.javajs.rbd.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import net.javajs.rbd.config.Paging;

import lombok.Data;

@Data
@Alias("freeboardVO")
public class FreeBoardVO {

	@NotNull
	private Integer ui_no;
	private String ui_nick;
	private Integer fre_no;
	@NotNull
	@Length(max = 200)
	private String fre_title;
	@NotNull
	@Length(max = 3000)
	private String fre_content;
	private String fre_credat; // 등록일
	private String fre_moddat; // 수정일
	private Integer fre_lookupcnt; // 조회수
	private Integer f_like; // 좋아요
	private List<FreeComentVO> freeComents;
	private Paging paging;
}
