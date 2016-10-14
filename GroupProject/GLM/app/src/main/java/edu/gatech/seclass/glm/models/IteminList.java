/**
 * Created by shuxu on 10/11/16.
 */

package edu.gatech.seclass.glm.models;

import edu.gatech.seclass.glm.models.IteminData;

public class IteminList extends IteminData {

    private String quantity;
    private boolean isChecked;
    public IteminList() {
    }

    // get methods

    public boolean getIsChecked() {
        return isChecked;
    }

    public String getQuantity() {
        return quantity;
    }


    // set methods
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}

