package Variables;

public class PrintfExample {
    public static void main(String[] args) {
        int value = 123;
        System.out.printf("상품의 가격: %d\n", value);
        System.out.printf("상품의 가격: %6d\n", value);
        System.out.printf("상품의 가격: %-6d\n", value);
        System.out.printf("상품의 가격: %06d\n", value);

        double area = 3.141592 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이: %10.2f\n",10,area);

        String name = "홍길동";
        String job = " 도적";
        System.out.printf("%6s | %-10s\n",name,job);


    }
}
