package com.secondstep.skillmatrix.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="employee_evaluation")
public class EmployeeEvaluation implements Serializable{
	
	@Id
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="employee_id")
    private Employee theEmployee;
	
	
	@Id
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="current_level_id")
    private SkillPerLevel theSkill;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="evaluation_source")
	private EvaluationSource theEvaluation;
	

	public EvaluationSource getTheEvaluation() {
		return theEvaluation;
	}

	public void setTheEvaluation(EvaluationSource theEvaluation) {
		this.theEvaluation = theEvaluation;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="current_id")
	private int currentId;
	
	
	@Column(name="evaluation_date")
	private Date evaluationDate;
	
	
	@Column(name="evaluation_by")
	private int evaluationBy;
	
	
	@Column(name="comment")
	private int comment;

	public Employee getTheEmployee() {
		return theEmployee;
	}

	public void setTheEmployee(Employee theEmployee) {
		this.theEmployee = theEmployee;
	}

	
	
	public SkillPerLevel getTheSkill() {
		return theSkill;
	}

	public void setTheSkill(SkillPerLevel theSkill) {
		this.theSkill = theSkill;
	}

	public int getCurrentId() {
		return currentId;
	}

	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}

	public Date getEvaluationDate() {
		return evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public int getEvaluationBy() {
		return evaluationBy;
	}

	public void setEvaluationBy(int evaluationBy) {
		this.evaluationBy = evaluationBy;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public EmployeeEvaluation(Date evaluationDate, int evaluationBy, int evaluationSource, int comment) {
		super();
		this.evaluationDate = evaluationDate;
		this.evaluationBy = evaluationBy;
		this.comment = comment;
	}

	

	public EmployeeEvaluation() {
		
	}

	@Override
	public String toString() {
		return "EmployeeEvaluation [currentId=" + currentId + ", evaluationDate=" + evaluationDate + ", evaluationBy="
				+ evaluationBy + ", comment=" + comment + "]";
	}

	

	
	
	
	
	

}
