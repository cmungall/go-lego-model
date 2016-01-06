package org.geneontology.lego.model.meta;

import com.google.common.base.Predicate;

public class Relation extends OntologyObject {

	public static String ENABLED_BY = "RO:0002333";
	public static String DIRECTLY_ACTIVATES = "RO:0002406";

	public static Predicate isEnabledBy = 
			new Predicate<LegoEdge>() {
		public boolean apply(LegoEdge e) {
			return e.getRelation().getId().equals(ENABLED_BY);
		}
	};

}
