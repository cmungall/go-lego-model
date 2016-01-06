/**
 * 
 */
package org.geneontology.lego.model.meta;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.geneontology.lego.model.bio.Activity;
import org.geneontology.lego.model.bio.MolecularEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author cjm
 *
 */
public class LegoModelTest {
	
	LegoFactory legoFactory;
	
	final String G1 = "G:1";
	final String A1 = "A:1";
	final String A2 = "A:2";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		legoFactory = new LegoFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		LegoModel legoModel = legoFactory.createLegoModel();
		Class<Activity> t = Activity.class;
		Activity a1 = legoFactory.createLegoNode(Activity.class, legoModel, "A:1");
		Activity a2 = legoFactory.createLegoNode(Activity.class, legoModel, "A:2");
		MolecularEntity g1= legoFactory.createLegoNode(MolecularEntity.class, legoModel, "G:1");
		legoFactory.createLegoEdge(legoModel, a1, Relation.ENABLED_BY, g1);
		legoFactory.createLegoEdge(legoModel, a1, Relation.DIRECTLY_ACTIVATES, a2);
		
		for (LegoEdge e : legoModel.getLegoEdgeSet()) {
			System.out.println(e);
		}
	
		assertEquals(0, legoModel.getIncomingEdges(a1).size());
		assertEquals(2, legoModel.getOutgoingEdges(a1).size());
		assertEquals(1, legoModel.getIncomingEdges(a2).size());
		assertEquals(1, legoModel.getIncomingEdges(g1).size());
		assertEquals(0, legoModel.getOutgoingEdges(g1).size());
		assertTrue(LegoUtil.getSubjects(legoModel.getIncomingEdges(a2)).contains(a1));
		assertTrue(LegoUtil.getObjects(legoModel.getOutgoingEdges(a1)).contains(a2));
		assertTrue(LegoUtil.getObjects(legoModel.getOutgoingEdges(a1)).contains(g1));
		
		assertEquals(1, a1.getEnabledByEdges().size());
		assertTrue(a1.getEnabledBy().contains(g1));
		
		
	}

}
