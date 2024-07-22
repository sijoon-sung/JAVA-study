package Interface.polymorphism;

public class Car {
    Tire frontLeftTire = new Hankook();
    Tire frontRightTire = new Hankook();
    Tire backLeftTire = new Kumho();
    Tire backRight = new Kumho();

    void run(){
        frontLeftTire.roll();
        frontRightTire.roll();
        backRight.roll(); //인터페이스에서 설명된 roll 메소드 호출
        backLeftTire.roll();
    }
}
