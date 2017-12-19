package ru.vsu.netcracker.models;

/**
 * Class of person with fields: <b>id</b> - autogenerate,
 * <b>model</b>, <b>color</b>, <b>enginePower</b>
 *{@value} count - general number of existing instances of this class
 *@author Pavel Kuchinsky
 *@version 1.0
 */
public class Car {

    private static int count = 0;
    private int id;
    private String model;
    private String color;
    private double enginePower;

    /**
     *@see Car#Car(String, String, double)
     */
    public Car() {
        id = count++;
    }

    /**
     * @param model
     * @param color
     * @param enginePower
     * @see Car#Car()
     */
    public Car(String model, String color, double enginePower) {
        id = count++;
        this.model = model;
        this.color = color;
        this.enginePower = enginePower;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return Car.class.getSimpleName() + "[ id = " + id + ", model = " + model +
                ", color = " + color + ", engine power = " + enginePower + " ]";
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return (car.id == this.id && car.model.equals(this.model)
                && car.color.equals(this.color) && car.enginePower == this.enginePower);
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (model == null ? 0 : model.hashCode());
        result = prime * result + (color == null ? 0: color.hashCode());
        result = prime * result + ((Double)enginePower).hashCode();
        return result;
    }
}
