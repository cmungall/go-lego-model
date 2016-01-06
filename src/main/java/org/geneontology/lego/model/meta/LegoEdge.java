package org.geneontology.lego.model.meta;

import java.util.Set;

import org.geneontology.lego.model.evidence.Evidence;

public class LegoEdge<T extends LegoNode,U extends LegoNode> {

	LegoNode subjectNode;
	Relation relation;
	LegoNode objectNode;
	Set<Evidence> evidenceSet;
	
	
	public LegoEdge(LegoNode subjectNode, Relation relation,
			LegoNode objectNode, Set<Evidence> evidenceSet) {
		super();
		this.subjectNode = subjectNode;
		this.objectNode = objectNode;
		this.relation = relation;
		this.evidenceSet = evidenceSet;
	}
	public LegoNode getSubjectNode() {
		return subjectNode;
	}
	public void setSubjectNode(LegoNode subjectNode) {
		this.subjectNode = subjectNode;
	}
	
	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	public LegoNode getObjectNode() {
		return objectNode;
	}
	public void setObjectNode(LegoNode objectNode) {
		this.objectNode = objectNode;
	}
	public Set<Evidence> getEvidenceSet() {
		return evidenceSet;
	}
	public void setEvidenceSet(Set<Evidence> evidenceSet) {
		this.evidenceSet = evidenceSet;
	}
	@Override
	public String toString() {
		return "LegoEdge [subjectNode=" + subjectNode + ", relation="
				+ relation + ", objectNode=" + objectNode + ", evidenceSet="
				+ evidenceSet + "]";
	}
	
	
	
}
