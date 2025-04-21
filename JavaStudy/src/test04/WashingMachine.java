package test04;

public class WashingMachine extends SmartDevice implements Updatable {

    @Override
    public void operate() {
        System.out.println("세탁기 작업");
    }

    @Override
    public void updateSoftware() {
        System.out.println("WashingMachine updateSoftware");
    }
}
