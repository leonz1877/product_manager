package ru.netology.domain;
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone (int id, String name, int coast, String manufacturer) {
        super(id, name, coast);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
