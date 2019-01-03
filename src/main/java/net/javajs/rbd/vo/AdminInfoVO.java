package net.javajs.rbd.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import net.javajs.rbd.config.Paging;

import lombok.Data;

@Data
@Alias("admininfoVo")
public class AdminInfoVO {

	private Integer ad_no;
	@NotNull
	private String ad_id;
	@NotNull
	private String ad_name;
	@NotNull
	private String ad_pwd;
	private String ad_nick;
	@NotNull
	private String ad_email;
	@NotNull
	private String ad_tell;
	private Integer ad_active;
	private Paging paging;
}
