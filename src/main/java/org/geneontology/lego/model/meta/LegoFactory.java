package org.geneontology.lego.model.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.geneontology.lego.model.bio.Activity;
import org.geneontology.lego.model.bio.MolecularEntity;

public class LegoFactory {
	
	Map<String, Relation> relationMap = new HashMap<String, Relation>();
	Map<String, OntologyClass> classMap = new HashMap<String, OntologyClass>();
	Map<String, LegoNode> legoNodeMap = 
			new HashMap<String, LegoNode>();
	
	LegoModel createLegoModel() {
		return new LegoModel();
	}
	
	<T extends LegoNode> T createLegoNode(Class<T> nodeType, LegoModel legoModel) throws InstantiationException, IllegalAccessException {
		return createLegoNode(nodeType, legoModel, null);
	}

	
	<T extends LegoNode> T createLegoNode(Class<T> nodeType, LegoModel legoModel, String id) throws InstantiationException, IllegalAccessException {
		if (legoNodeMap.containsKey(id)) {
			LegoNode obj = legoNodeMap.get(id);
			return (T) obj;
		}
		T n = nodeType.newInstance();
		n.setId(id);
		n.setLegoModel(legoModel);
		legoNodeMap.put(id, n);
		return n;
	}

	public LegoEdge createLegoEdge(LegoModel legoModel, LegoNode subjectNode, Relation r,
			LegoNode objectNode) {
		LegoEdge e = new LegoEdge(subjectNode, r, objectNode, null);
		legoModel.addLegoEdge(e);
		return e;
		
	}
	public LegoEdge createLegoEdge(LegoModel legoModel, LegoNode subjectNode, String rid,
			LegoNode objectNode) {
		Relation r = getRelation(rid);
		return createLegoEdge(legoModel, subjectNode, r, objectNode);

	}

	public LegoEdge createLegoEdge(LegoModel legoModel, String sid, String rid,
			String oid) throws InstantiationException, IllegalAccessException {
		Class<LegoNode> t = LegoNode.class;
		LegoNode subjectNode = createLegoNode(t, legoModel, sid);
		LegoNode objectNode = createLegoNode(t, legoModel, oid);
		Relation r = getRelation(rid);
		LegoEdge e = createLegoEdge(legoModel, subjectNode, r, objectNode);
		return e;
	}

	private Relation getRelation(String rid) {
		if (!relationMap.containsKey(rid)){
			Relation r = new Relation();
			r.setId(rid);
			relationMap.put(rid, r);
		}
		return relationMap.get(rid);
	}



}
