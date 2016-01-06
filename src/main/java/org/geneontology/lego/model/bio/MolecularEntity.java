package org.geneontology.lego.model.bio;

import java.util.Collection;
import java.util.Set;

import org.geneontology.lego.model.meta.LegoNode;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class MolecularEntity extends LegoNode {
	Set<Activity> getActivities() {
		return null;
	}
	
	public static Function<LegoNode, MolecularEntity> AS = new Function<LegoNode, MolecularEntity>() {
		public MolecularEntity apply(final LegoNode n) {
			return (MolecularEntity)n;
		}
	};

	public static Collection<MolecularEntity> as(Collection<LegoNode> nodes) {
		return Collections2.transform(nodes, AS);
	}

}
