package org.demo.entity;

public class Mobile {
    private int id;
    private String brand;
    private int ram;
    private String name;
    private int externalStorage;

    public Mobile() {
    }

    public Mobile(int id, String brand, int ram, String name, int externalStorage) {
        this.id = id;
        this.brand = brand;
        this.ram = ram;
        this.name = name;
        this.externalStorage = externalStorage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExternalStorage() {
        return externalStorage;
    }

    public void setExternalStorage(int externalStorage) {
        this.externalStorage = externalStorage;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", ram=" + ram +
                ", name='" + name + '\'' +
                ", externalStorage=" + externalStorage +
                '}';
    }
}
