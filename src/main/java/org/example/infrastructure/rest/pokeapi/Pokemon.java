package org.example.infrastructure.rest.pokeapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    public List<Form> forms;
    public int id;

    public String name;

    public List<Ability> abilities;

    public int weight;

    public int order;

    private class Form {
        public String name;
        public String url;

        @Override
        public String toString() {
            return " name: " + name + " url: " + url ;
        }
    }


    private class Ability {
        //        @SerializedName("is_hidden")3
        public boolean isHidden;
        public int slot;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}
