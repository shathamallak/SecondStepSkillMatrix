package com.secondstep.skillmatrix.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;






@Entity
@Table(name="evaluation_source")
public class EvaluationSource {
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="source_id")
	private int sourceId;
	
	
	@Column(name="source")
	private String source;
	
	
	@OneToMany(mappedBy="myEvaluation",cascade=CascadeType.ALL)	
	private List<EmployeeEvaluation> theEvaluation;
	
	public void addEvaluation(EmployeeEvaluation temp) {
		if(theEvaluation==null)
			theEvaluation=new ArrayList<>();
		theEvaluation.add(temp);
		temp.setTheEvaluation(this);
		
	}
	
	
	public List<EmployeeEvaluation> getTheEvaluation() {
		return theEvaluation;
	}
	public void setTheEvaluation(List<EmployeeEvaluation> theEvaluation) {
		this.theEvaluation = theEvaluation;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	public EvaluationSource(String source) {
		
		this.source = source;
	}
	
	public EvaluationSource() {
		
	}
	@Override
	public String toString() {
		return "EvaluationSource [sourceId=" + sourceId + ", source=" + source + "]";
	}
	
	

}
