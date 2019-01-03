package net.javajs.rbd.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import net.javajs.rbd.config.Paging;

import lombok.Data;

@Data
@Alias("freecomentVO")
public class FreeComentVO {
	
	private Integer freco_no;
	@NotNull
	private String freco_content;
	private String freco_credat;
	private String freco_moddat;
	@NotNull
	private Integer fre_no;
	@NotNull
	private Integer ui_no; //nick?name?id?찾아야해
	private Paging paging;
}
