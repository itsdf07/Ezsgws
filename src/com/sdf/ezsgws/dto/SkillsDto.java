package com.sdf.ezsgws.dto;

/**
 * 技能
 *
 * @author itsdf
 * @since 2015.7.5
 */
public class SkillsDto {

	private String id;

	/** 技能名称 */
	private String name;
	/** 技能图标 */
	private String icon;
	/** 快捷键 */
	private String shortCut;
	/** 技能信息 */
	private String info;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getShortCut() {
		return shortCut;
	}

	public void setShortCut(String shortCut) {
		this.shortCut = shortCut;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
