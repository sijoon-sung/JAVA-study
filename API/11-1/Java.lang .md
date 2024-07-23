- **Object**: 자바 클래스의 최상위 클래스로, 모든 클래스는 암시적으로 `Object` 클래스를 상속합니다.
- **System**: 표준 입력 및 출력, JVM 초기화, 시스템 속성 및 환경 변수 등의 기능을 제공합니다.
- **Class**: 런타임에 클래스의 메타데이터를 다룰 수 있는 기능을 제공합니다.
- **String**: 문자열을 저장하고 조작하는 다양한 메소드를 제공합니다.
- **Wrapper**: 기본 타입을 객체로 변환하고, 객체를 기본 타입으로 변환하는 기능을 제공합니다.
- **Math**: 수학 함수 및 상수를 제공합니다.

---

### Object 클래스

모든 자바 클래스는 `java.lang.Object` 클래스를 상속합니다. 주요 메소드로는 `equals()`, `hashCode()`, `toString()` 등이 있습니다.

- **equals()**: 두 객체가 동일한지 비교합니다. 기본적으로는 `==` 연산자와 같은 기능을 하지만, 필요에 따라 오버라이딩할 수 있습니다.
- **hashCode()**: 객체의 해시 코드를 반환합니다. 컬렉션 프레임워크에서 객체 비교에 사용됩니다.
- **toString()**: 객체의 문자열 표현을 반환합니다. 사용자가 원하는 형태로 오버라이딩할 수 있습니다.

```java
public boolean equals(Object obj) {
    if (obj instanceof Member) {
        Member member = (Member) obj;
        return id.equals(member.id);
    }
    return false;
}

```

```java
public class MemberExample {
    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if (obj1.equals(obj2)) {
            System.out.println("obj1와 obj2 값은 동일합니다");
        } else {
            System.out.println("obj1와 obj2 값은 동일하지 않습니다");
        }

        if (obj1.equals(obj3)) {
            System.out.println("obj1과 obj3은 동등합니다");
        } else {
            System.out.println("obj1과 obj3은 동등하지 않습니다");
        }
    }
}

```

---

### System 클래스

`System` 클래스는 자바 프로그램이 운영체제와 상호작용할 수 있게 해줍니다.

- **exit()**: JVM을 강제 종료합니다.
- **currentTimeMillis()**, **nanoTime()**: 현재 시간을 밀리초 또는 나노초 단위로 반환합니다.

```java
public class SystemTimeExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int sum = 0;
        for (int i = 1; i <= 100000; i++) {
            sum += i;
        }

        long endTime = System.nanoTime();
        System.out.println("계산에 " + (endTime - startTime) + " 나노초가 소요되었습니다.");
    }
}

```

---

### Class 클래스

`Class` 객체는 클래스의 메타데이터를 다룹니다. 클래스 이름, 생성자 정보, 필드 정보, 메소드 정보를 제공합니다.

```java
Class clazz = Car.class;
Class clazz = Class.forName("polymorphism.Car");
Car car = new Car();
Class clazz = car.getClass();

```

---

### String 클래스

`String` 클래스는 문자열을 저장하고 조작하는 다양한 메소드를 제공합니다.

- **charAt()**: 주어진 인덱스의 문자를 반환합니다.
- **equals()**: 두 문자열이 동일한지 비교합니다.
- **getBytes()**: 문자열을 바이트 배열로 변환합니다.

```java
public class StringCharAtExample {
    public static void main(String[] args) {
        String ssn = "012345-22345";
        char sex = ssn.charAt(7);
        switch (sex) {
            case '1': case '3':
                System.out.println("남자입니다");
                break;
            case '2': case '4':
                System.out.println("여자입니다");
                break;
        }
    }
}

```

---

### Wrapper 클래스

기본 타입을 객체로 포장하는 클래스입니다. 박싱과 언박싱을 통해 기본 타입 값과 객체 간의 변환을 지원합니다.

```java
Integer obj = 100; // 자동 박싱
int value = obj; // 자동 언박싱

```

---

### Math 클래스

수학 함수 및 상수를 제공하는 클래스입니다. 모든 메소드는 정적 메소드로 제공됩니다.

```java
double result = Math.ceil(5.3); // 6.0

```

---

블로그 참고
https://velog.io/@joon0404/11.1-java.lang-%ED%8C%A8%ED%82%A4%EC%A7%80
