public class Main {
    public static void main(String[] args) {
        String strVar1 = "시준";
        String strVar2 = "시준";

        if (strVar1 == strVar2) {
            System.out.println("두 변수는 참조가 같다");
        } else {
            System.out.println("두 변수는 참조가 다름");
        }

        if (strVar1.equals(strVar2)) {
            System.out.println("strVar1과 strVar2는 문자열이 같음");
        }

        String strVar3 = new String("성시준");
        String strVar4 = new String("성시준");

        if (strVar3 == strVar4) {
            System.out.println("두 변수는 참조가 같다");
        } else {
            System.out.println("두 변수는 참조가 다름");
        }

        if (strVar3.equals(strVar4)) {
            System.out.println("strVar3과 strVar4는 문자열이 같음");
        }
    }
}
