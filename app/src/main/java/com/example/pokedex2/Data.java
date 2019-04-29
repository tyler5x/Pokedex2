package com.example.pokedex2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Data {
    @SerializedName("count")
    private Integer count;
    @SerializedName("previous")
    private Object previous;
    @SerializedName("results")
    private List<Pokemon> results = null;
    @SerializedName("next")
    private String next;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }


    public class Pokemon {

        @SerializedName("url")
        private String url;
        @SerializedName("name")
        private String name;
        private String ability;
        private String type;

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

        public String getAbility() {
            return ability;
        }

        public void setAbility(String ability) {
            this.ability = ability;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
