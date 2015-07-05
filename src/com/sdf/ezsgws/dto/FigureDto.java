package com.sdf.ezsgws.dto;

import java.util.List;

/**
 * 人物实体类
 *
 * @author itsdf
 * @since 2015.7.5
 *
 */
public class FigureDto {

	private String id;

	private String name;
	/** 人物头像 */
	private String headIcon;
	/** 人物摘要，简介 */
	private String profile;
	/** 专属 */
	private String only;
	/** 技能 */
	private List<SkillsDto> skills;

}
