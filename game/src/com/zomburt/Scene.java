package com.zomburt;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Scene {
    JSONObject sceneObj;
    String sceneName;
    String flavorText;
    Object movement;
    String look;
    String search;
    ArrayList<String> feature;
    ArrayList<String> roomLoot;

//    public Scene() {
//        no arg
//        flavorText = "";
//        movement = new Object();
//        roomLoot = new ArrayList<String>();
//        feature = new ArrayList<String>();
//    }

    public Scene(String locationName) throws Exception {
        setSceneObject(locationName);
        setSceneName(locationName);

    }

    public void setSceneObject(String locationName) throws Exception {
        Object store = new JSONParser().parse(new FileReader("./game/assets/store.json"));
        JSONObject joStore = (JSONObject) store;
        JSONObject sceneObj = (JSONObject) joStore.get(locationName);
        this.sceneObj = sceneObj;
        setFlavorText();
        setMovement();
        setLook();
        setSearch();
        setFeature();
//        setRoomLoot();
    }
    public Object getSceneObj() {
        return sceneObj;
    }

    public String getSceneName() {
        return sceneName;
    }
    public void setSceneName(String locationName) {
        sceneName = locationName;
    }

    public String getFlavorText() {
        return flavorText;
    }
    public void setFlavorText() {
        flavorText = (String) sceneObj.get("flavorText");
    }

    public Object getMovement() {
        return movement;
    }
    public void setMovement() {
        movement = (Object) sceneObj.get("movement");
    }

    public String getLook() {
        return look;
    }
    public void setLook() {
        look = (String) sceneObj.get("look");
    }

    public String getSearch() {
        return search;
    }
    public void setSearch() {
        search = (String) sceneObj.get("search");
    }

    public ArrayList<String> getFeature() {
        return feature;
    }
    public void setFeature() {
//        feature = new ArrayList<String> ((String) sceneObj.get("feature"))Arrays.asList(str.split(","));
        try {
            String[] strFeature = (String[]) sceneObj.get("feature");
            feature = new ArrayList<String>(Arrays.asList(strFeature));
        } catch (Exception e) {
            feature = null;
        }
    }

    public ArrayList<String> getRoomLoot() {
        return roomLoot;
    }
    public void setRoomLoot() {
//        roomLoot = (ArrayList<String>) sceneObj.get("roomLoot");
        String[] strRoomLoot = (String[]) sceneObj.get("roomLoot");
        roomLoot = new ArrayList<String>(Arrays.asList(strRoomLoot));
    }

    @Override
    public String toString() {
        return "Scene{" +
                "sceneObj=" + sceneObj +
                ", flavorText='" + flavorText + '\'' +
                ", movement=" + movement +
                ", look='" + look + '\'' +
                ", search='" + search + '\'' +
                ", feature=" + feature +
                ", roomLoot=" + roomLoot +
                '}';
    }

}
