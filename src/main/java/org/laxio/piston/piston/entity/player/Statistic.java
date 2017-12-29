package org.laxio.piston.piston.entity.player;

public class Statistic {

    private final String name;
    private int value;

    public Statistic(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

}
