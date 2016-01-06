package org.geneontology.lego.model.meta;

import java.util.Collection;
import java.util.Set;

public class LegoNode {
	String id;
	LegoModel legoModel;
	Set<OntologyClass> typeSet;
	
	
	
//	public LegoNode(LegoModel legoModel, String id) {
//		super();
//		this.id = id;
//		this.legoModel = legoModel;
//	}
//	public static LegoNode create(LegoModel legoModel, String id) {
//		return new LegoNode(legoModel, id);
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LegoModel getLegoModel() {
		return legoModel;
	}
	public void setLegoModel(LegoModel legoModel) {
		this.legoModel = legoModel;
	}
	public Set<OntologyClass> getTypeSet() {
		return typeSet;
	}
	public void setTypeSet(Set<OntologyClass> typeSet) {
		this.typeSet = typeSet;
	}
	
	public Collection<LegoEdge> getOutgoingEdges() {
		return getLegoModel().getOutgoingEdges(this);
	}
	@Override
	public String toString() {
		return "LegoNode [id=" + id + ", legoModel=" + legoModel + ", typeSet="
				+ typeSet + "]";
	}
	
	
}
