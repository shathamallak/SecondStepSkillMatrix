package com.secondstep.skillmatrix.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="skill_per_level")
public class SkillPerLevel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skill_per_level_id")
	private int skillPerLevelId;
	
	@ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;
	@ManyToOne
	@JoinColumn(name="skill_level_id")
	private SkillLevel skilllevel;
	@Column(name="description")
	private String description;
	
	public SkillPerLevel(){		
	
	}
	
	public SkillPerLevel(Skill skill, SkillLevel skilllevel, String description) {
		super();
		this.skill = skill;
		this.skilllevel = skilllevel;
		this.description = description;
	}
	
	
	
}
