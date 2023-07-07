package etu2091.obj;

import java.util.HashMap;

public class ModelView{
    String view;
    HashMap<String,Object> data = new HashMap<String,Object>();

    public ModelView(String view){
        this.view = view;
    }
    public ModelView(){}

    public String getView() {return view;}
    public void setView(String view) {this.view = view;}

    public HashMap<String,Object> getData() {
        return data;
    }

    public void addItem(String key, Object value) {
        data.put(key, value);
    }
}