package com.secondstep.skillmatrix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skill_id")
	private int skillId;
	@Column(name="skill_title")
	private String SkillTitle;
	@Column(name="description")
	private String description;
	
	
	@OneToMany(mappedBy = "skills", cascade = CascadeType.ALL)
	private List<SkillLevel>skilllevels;
	
	
	
	public List<SkillLevel> getSkilllevels() {
		return skilllevels;
	}

	public void setSkilllevels(List<SkillLevel> skilllevels) {
		this.skilllevels = skilllevels;
	}

	public Skill() {
		
		
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillTitle() {
		return SkillTitle;
	}

	public void setSkillTitle(String skillTitle) {
		SkillTitle = skillTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Skill(String skillTitle, String description) {
		super();
		SkillTitle = skillTitle;
		this.description = description;
	}
	
}
