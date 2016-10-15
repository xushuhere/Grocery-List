package edu.gatech.seclass.glm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.glm.models.GroceryList;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuxu on 10/14/16.
 */

public class GroceryListTest extends GroceryList {
    private GroceryList list;

    @Before
    public void setUp() {
        list = new GroceryList();
    }

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void testSetId() {
        list.setId("ListId1");
        assertEquals("ListId1", list.getId());
    }


    @Test
    public void testSetName() {
        list.setName("Name1");
        assertEquals("Name1", list.getName());
    }

}
