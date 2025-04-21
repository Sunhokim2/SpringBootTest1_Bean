package test04;

public class AirConditioner
extends SmartDevice implements Updatable {


    @Override
    public void updateSoftware() {
        System.out.println("에어컨 업데이트");
    }

    @Override
    public void operate() {
        System.out.println("에어컨 작업");
    }
}
