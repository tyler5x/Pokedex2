package com.example.pokedex2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Data {
    @SerializedName("results")
    private List<Pokemon> results = null;
    @SerializedName("types")
    private List<Type> types = null;
    @SerializedName("abilities")
    private List<Ability> abilities = null;

    public List<Type> getTypes() {
        return types;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public class Type {
        @SerializedName("url")
        private String url;
        @SerializedName("name")
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Ability {
        @SerializedName("url")
        private String url;
        @SerializedName("name")
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Pokemon {

        @SerializedName("url")
        private String url;
        @SerializedName("name")
        private String name;


        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
