/**
 * 
 */
package org.geneontology.lego.model.meta;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.geneontology.lego.model.bio.Activity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author cjm
 *
 */
public class LegoEdgeTest {
	
	LegoFactory legoFactory;
	
	final String N1 = "N:1";
	final String N2 = "N:2";
	final String N3 = "N:3";
	final String R1 = "R:1";

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
		Activity n1 = legoFactory.createLegoNode(t, legoModel, N1);
		Activity n2 = legoFactory.createLegoNode(t, legoModel, N2);
		Activity n3 = legoFactory.createLegoNode(t, legoModel, N3);
		legoFactory.createLegoEdge(legoModel, N1, R1, N2);
		legoFactory.createLegoEdge(legoModel, N2, R1, N3);
		
		for (LegoEdge e : legoModel.getLegoEdgeSet()) {
			System.out.println(e);
		}
	
		assertEquals(0, legoModel.getIncomingEdges(n1).size());
		assertEquals(1, legoModel.getOutgoingEdges(n1).size());
		assertEquals(1, legoModel.getIncomingEdges(n2).size());
		assertEquals(1, legoModel.getOutgoingEdges(n2).size());
		assertTrue(LegoUtil.getSubjects(legoModel.getIncomingEdges(n2)).contains(n1));
		assertTrue(LegoUtil.getObjects(legoModel.getOutgoingEdges(n2)).contains(n3));
		
	}

}
