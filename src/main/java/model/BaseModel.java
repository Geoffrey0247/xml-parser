package model;

import java.util.ArrayList;

/**
 * Created by GBC on 2016/12/15.
 */

public class BaseModel {
    private String name;
    private String value;
    private ArrayList<String> details;

    public BaseModel(String name, String value) {
        this.name = name;
        this.value = value;
        details = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }
}
