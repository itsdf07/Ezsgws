package com.sdf.ezsgws.dto;

import java.util.ArrayList;
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

	/** 人物名称 */
	private String name;
	/** 人物头像 */
	private String headIcon;
	/** 人物摘要，简介 */
	private String profile;
	/** 专属 */
	private String only;
	/** 技能 */
	private List<SkillsDto> skillsList = new ArrayList<SkillsDto>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getOnly() {
		return only;
	}

	public void setOnly(String only) {
		this.only = only;
	}

	public List<SkillsDto> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<SkillsDto> skillsList) {
		this.skillsList = skillsList;
	}

	/**
	 * 添加技能信息到技能列表中
	 *
	 * @param skill
	 *            技能
	 */
	public void addSkillToList(SkillsDto skill) {
		if (skillsList == null) {
			skillsList = new ArrayList<SkillsDto>();
		}
		skillsList.add(skill);

	}

}
