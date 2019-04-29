package com.example.pokedex2;

public class Pokemon {
    private int number;
    private String name;
    private String url;
    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
