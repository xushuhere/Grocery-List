package edu.gatech.seclass.glm.models;

/**
 * Created by shuxu on 10/11/16.
 */

public class IteminData {
    public String id;
    public String name;
    private String type;
    private String quantityUnit;

    // constructors
    public IteminData() {
    }

    public IteminData(String _type, String _name, String _quantityUnit) {
        name = _name;
        type = _type;
        quantityUnit=_quantityUnit;
    }

    // get methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    // set methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

}
