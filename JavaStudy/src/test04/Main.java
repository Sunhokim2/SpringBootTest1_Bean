package test04;



public class Main {
  public static void main(String[] args) {
    WashingMachine wm = new WashingMachine();
    SmartDevice[] devices = {
            wm, new AirConditioner()
            // WashingMachine 객체 생성
            // AirConditioner 객체 생성
    };

    for (SmartDevice d : devices) {
      // 전원 ON
      d.turnOn();

      // 기기 동작
      d.operate();

      // 기기 업데이트
      ((Updatable) d).updateSoftware();

      // 전원 OFF
      d.turnOff();
    }


  }
}
