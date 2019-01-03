package net.javajs.rbd.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("fanComentVo")
public class FanComentVO {
	
	private Integer fanco_no;
	@NotNull
	private String fanco_content;
	private String fanco_credat;
	private String fanco_moddat;
	@NotNull
	private Integer ui_no;
	@NotNull
	private Integer fan_no;
}
