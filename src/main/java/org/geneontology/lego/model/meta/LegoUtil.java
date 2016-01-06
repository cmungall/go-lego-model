package org.geneontology.lego.model.meta;

import java.util.Collection;

import org.geneontology.lego.model.bio.Activity;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class LegoUtil {
	public static Function<LegoEdge, LegoNode> SUBJECT = new Function<LegoEdge, LegoNode>() {
		public LegoNode apply(final LegoEdge e) {
			return e.getSubjectNode();
		}
	};
	public static Function<LegoEdge, LegoNode> OBJECT = new Function<LegoEdge, LegoNode>() {
		public LegoNode apply(final LegoEdge e) {
			return e.getObjectNode();
		}
	};
	

	public static Collection<LegoNode> getSubjects(Collection<LegoEdge> edges) {
		return Collections2.transform(edges, SUBJECT);
	}
	
	public static Collection<LegoNode> getObjects(Collection<LegoEdge> edges) {
		return Collections2.transform(edges, OBJECT);
	}
	


}
