package com.secondstep.skillmatrix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="skill_level")
public class SkillLevel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skill_level_id")
	private int skillLevelld;
	
	@Column(name="skill_level")
	private String skillLevel;
	public SkillLevel() {
		
	}
	public int getSkillLeveld() {
		return skillLevelld;
	}
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="SkillPerLevel",
			joinColumns=@JoinColumn(name="skill_level_id"),
			inverseJoinColumns=@JoinColumn(name="skill_id"))
	private List<Skill>skills;
	
	public int getSkillLevelld() {
		return skillLevelld;
	}
	public void setSkillLevelld(int skillLevelld) {
		this.skillLevelld = skillLevelld;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public void setSkillLeveld(int skillLeveld) {
		this.skillLevelld = skillLeveld;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public SkillLevel(String skillLevel) {
		super();
		this.skillLevel = skillLevel;
	}
	
}
