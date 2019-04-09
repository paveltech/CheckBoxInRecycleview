package com.playoffstudio.checkboxinrecycleview;

public class MyPojo {

    public int id;
    public boolean isSelect;
    public String name;

    public MyPojo(int id, boolean isSelect, String name) {
        this.id = id;
        this.isSelect = isSelect;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "name: " + name + "id: " + id + "select: " + isSelect;
    }
}
