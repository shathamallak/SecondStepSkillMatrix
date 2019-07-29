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
@Table(name="skill_per_role")
public class SkillPerRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skill_per_role_id")
	private int skillPerRoleId;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@ManyToOne
    @JoinColumn(name="target_skill_level")
	private SkillLevel skilllevel;
	
	@Column(name="weight")
	private float weight;

	public SkillPerRole(Role role, SkillLevel skilllevel, float weight) {
		super();
		this.role = role;
		this.skilllevel = skilllevel;
		this.weight = weight;
	}
	public SkillPerRole() {
		
		
	}
	public int getSkillPerRoleId() {
		return skillPerRoleId;
	}

	public void setSkillPerRoleId(int skillPerRoleId) {
		this.skillPerRoleId = skillPerRoleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SkillLevel getSkilllevel() {
		return skilllevel;
	}

	public void setSkilllevel(SkillLevel skilllevel) {
		this.skilllevel = skilllevel;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
	
	
	
	
	
	

}
