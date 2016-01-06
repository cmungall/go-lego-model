package org.geneontology.lego.model.bio;

import java.util.Collection;
import java.util.Set;

import org.geneontology.lego.model.meta.LegoEdge;
import org.geneontology.lego.model.meta.LegoNode;
import org.geneontology.lego.model.meta.LegoUtil;
import org.geneontology.lego.model.meta.Relation;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class Activity extends Occurrent {

	public Collection<LegoEdge> getEnabledByEdges() {
		return Collections2.filter(getLegoModel().getOutgoingEdges(this),
				Relation.isEnabledBy);
	}

	public Collection<MolecularEntity> getEnabledBy() {
		return MolecularEntity.as(LegoUtil.getObjects(getEnabledByEdges()));
	}
	
	public static Function<LegoNode, Activity> AS = new Function<LegoNode, Activity>() {
		public Activity apply(final LegoNode n) {
			return (Activity)n;
		}
	};

	public static Collection<Activity> as(Collection<LegoNode> nodes) {
		return Collections2.transform(nodes, AS);
	}

}
