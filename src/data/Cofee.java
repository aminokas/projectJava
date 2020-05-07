package data;

import java.io.Serializable;

public class Cofee implements Serializable {
    private Long id;
    private String name;
    private String vkus;
    private int count = 0;

    public Cofee() {}
    public Cofee(Long id, String name, int count, String vkus) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.vkus = vkus;
    }


    public Cofee(Long id, String name, String vkus, int count) {
    }

    public Cofee(Object o, String text, String text1, int parseInt, String text2) {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getVkus() {
        return vkus;
    }
    public void setVkus(String genre) {
        this.vkus = genre;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", genre='" + vkus + '\'' ;
    }


}


