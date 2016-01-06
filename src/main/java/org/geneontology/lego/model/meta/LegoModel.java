package org.geneontology.lego.model.meta;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

public class LegoModel {

	Set<LegoNode> legoNodeSet = new HashSet<LegoNode>();
	Set<LegoEdge> legoEdgeSet= new HashSet<LegoEdge>();
	
	public Set<LegoNode> getLegoNodeSet() {
		return legoNodeSet;
	}
	public void setLegoNodeSet(Set<LegoNode> legoNodeSet) {
		this.legoNodeSet = legoNodeSet;
	}
	public Set<LegoEdge> getLegoEdgeSet() {
		return legoEdgeSet;
	}
	public void setLegoEdgeSet(Set<LegoEdge> legoEdgeSet) {
		this.legoEdgeSet = legoEdgeSet;
	}
	
	public Collection<LegoEdge> getOutgoingEdges(LegoNode node) {
		final LegoNode finalNode = node;
		return Collections2.filter(legoEdgeSet, new Predicate<LegoEdge>() {
			  public boolean apply(LegoEdge e) {
				    return e.getSubjectNode().equals(finalNode);
				  }
				});
	}
	public Collection<LegoEdge> getIncomingEdges(LegoNode node) {
		final LegoNode finalNode = node;
		return Collections2.filter(legoEdgeSet, new Predicate<LegoEdge>() {
			  public boolean apply(LegoEdge e) {
				    return e.getObjectNode().equals(finalNode);
				  }
				});
	}
	
	
	public void addLegoEdge(LegoEdge e) {
		legoEdgeSet.add(e);
		
	}
	

}
