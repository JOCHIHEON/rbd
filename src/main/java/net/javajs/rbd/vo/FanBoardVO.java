package net.javajs.rbd.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import net.javajs.rbd.config.Paging;

import lombok.Data;

@Data
@Alias("fanBoardVo")
public class FanBoardVO {
	
	private Integer fan_no;
	@NotNull
	@Length(max=200)
	private String fan_title;
	@NotNull
	@Length(max=3000)
	private String fan_content;
	private String fan_credat;
	private String fan_moddat;
	private Integer lookupcnt;
	private Integer fan_lookupcnt;
	private Integer f_like;
	@NotNull
	private Integer ui_no;
	private String ui_nick;
	private Paging paging;
	private List<FanComentVO> fanComents;
}
