package edu.gatech.seclass.glm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.glm.models.IteminList;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuxu on 10/14/16.
 */

public class IteminListTest extends IteminList {


    private IteminList item;

    @Before
    public void setUp() {
        item = new IteminList();
    }

    @After
    public void tearDown() {
        item = null;
    }

    @Test
    public void testSetId() {
        item.setId("ItemId1");
        assertEquals("ItemId1", item.getId());
    }


    @Test
    public void testSetName() {
        item.setName("Name1");
        assertEquals("Name1", item.getName());
    }

    @Test
    public void testSetType() {
        item.setType("Type1");
        assertEquals("Type1", item.getType());
    }


    @Test
    public void testSetQuantityUnit() {
        item.setQuantityUnit("Unit1");
        assertEquals("Unit1", item.getQuantityUnit());
    }


    @Test
    public void testSetQuantity() {
        item.setQuantity("11.2");
        assertEquals("11.2", item.getQuantity());
    }


    @Test
    public void testSetChecked() {
        item.setChecked(false);
        assertEquals(false, item.getIsChecked());
    }
}
