package br.com.GabrielIDSM.EncryptorAPI.Model;

public class MessageRequestModelToEnigmaSwissK {
    
    private String message;
    private int rotorOne;
    private int rotorTwo;
    private int rotorThree;
    private int rotorOneWheelSet;
    private int rotorTwoWheelSet;
    private int rotorThreeWheelSet;
    private int reflectorWheelSet;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRotorOne() {
        return rotorOne;
    }

    public void setRotorOne(int rotorOne) {
        this.rotorOne = rotorOne;
    }

    public int getRotorTwo() {
        return rotorTwo;
    }

    public void setRotorTwo(int rotorTwo) {
        this.rotorTwo = rotorTwo;
    }

    public int getRotorThree() {
        return rotorThree;
    }

    public void setRotorThree(int rotorThree) {
        this.rotorThree = rotorThree;
    }

    public int getRotorOneWheelSet() {
        return rotorOneWheelSet;
    }

    public void setRotorOneWheelSet(int rotorOneWheelSet) {
        this.rotorOneWheelSet = rotorOneWheelSet;
    }

    public int getRotorTwoWheelSet() {
        return rotorTwoWheelSet;
    }

    public void setRotorTwoWheelSet(int rotorTwoWheelSet) {
        this.rotorTwoWheelSet = rotorTwoWheelSet;
    }

    public int getRotorThreeWheelSet() {
        return rotorThreeWheelSet;
    }

    public void setRotorThreeWheelSet(int rotorThreeWheelSet) {
        this.rotorThreeWheelSet = rotorThreeWheelSet;
    }

    public int getReflectorWheelSet() {
        return reflectorWheelSet;
    }

    public void setReflectorWheelSet(int reflectorWheelSet) {
        this.reflectorWheelSet = reflectorWheelSet;
    }
    
}
