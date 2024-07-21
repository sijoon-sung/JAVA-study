## 자동 타입 변환

자동 타입 변환은 말 그대로 자동으로 타입 변환이 일어나는 것입니다.

### 정의
- 큰 허용 범위 타입 = 작은 허용 범위 타입

### 설명
- 자동 타입 변환은 프로그램 실행 중에 자동으로 타입이 변경되는 것을 의미합니다.

### 범위
- byte < short < int < long < float < double

예를 들어, `int` 타입이 `byte` 타입보다 허용 범위가 더 크기 때문에 자동 타입 변환이 일어납니다.

```java
byte byteValue = 10;
int intValue = byteValue; // 자동 타입 변환
```

정수 타입이 실수 타입으로 저장될 경우에도 자동 타입 변환이 일어나는데, 이는 실수 타입의 범위가 정수 타입보다 크기 때문입니다.

```java
long longValue = 5000000L;
float floatValue = longValue; // 5.0E9
double doubleValue = longValue; // 5.0E9
```

`char` 타입인 경우, `int` 타입으로 자동 변환되면 유니코드의 값이 `int`로 저장됩니다.

```java
char charValue = 'A';
int intValue = charValue; // 65
```

---

### 자동 타입 변환의 예

- **문제 설명**: 
  - `char` 타입보다 허용 범위가 작은 `byte` 타입은 `char` 타입으로 자동 타입 변환될 수 없습니다. 
  - 그 이유는 `char` 타입이 음수를 포함하지 않지만, `byte` 타입은 음수를 포함하기 때문입니다.

- **예제 코드**:
```java
byte byteValue = 65;
char charValue = byteValue; // 오류 발생
```

---

### 전체 예제 코드

```java
package Variables;

public class PromotionExample {
    public static void main(String[] args) {
        // 자동 타입 변환
        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println("intValue: " + intValue);

        char charValue = '가';
        intValue = charValue;
        System.out.println("가의 유니코드: " + charValue);

        intValue = 50;
        long longValue = intValue;
        System.out.println("longValue: " + longValue);

        intValue = 100;
        float floatValue = longValue;
        System.out.println("floatValue: " + floatValue);

        floatValue = 100.5F;
        double doubleValue = floatValue;
        System.out.println("doubleValue: " + doubleValue);
    }
}
```

**실행 결과:**
```
intValue: 10
가의 유니코드: 가
longValue: 50
floatValue: 50.0
doubleValue: 100.5
```

---

## 강제 타입 변환

큰 허용 범위 타입에서 작은 허용 범위 타입으로 변환할 수 없는 경우, **강제 타입 변환**을 사용합니다.

### 정의
- 작은 허용 범위 타입 = (작은 허용 범위 타입) 큰 허용 범위 타입

### 설명
- 강제 타입 변환은 큰 타입을 작은 타입으로 변환하는 과정을 의미합니다.

### 예제 코드

```java
int intValue = 10;
byte byteValue = (byte) intValue; // 강제 타입 변환
```

```java
int intValue = 65;
char charValue = (char) intValue;
System.out.println(charValue); // 65가 출력
```

### 전체 예제 코드

```java
package Variables;

public class CastingExample {
    public static void main(String[] args) {
        int intValue = 44032;
        char charValue = (char) intValue;
        System.out.println(charValue); // 가

        long longValue = 500;
        intValue = (int) longValue;
        System.out.println(intValue); // 500

        double doubleValue = 3.14;
        intValue = (int) doubleValue;
        System.out.println(intValue); // 3
    }
}
```

---

## 정수 연산에서의 자동 타입 변환

자바에서 변수의 타입에 따라 연산자가 다르게 해석될 수 있습니다. 

### 예제 코드

#### 1. `byte` 타입 변수가 피연산자로 사용된 경우

```java
byte x = 10;
byte y = 20;
// byte result = x + y; // 컴파일 에러
int result = x + y; // 올바른 코드
```

여기서 `byte result = x + y;`는 컴파일 에러가 발생합니다. 이는 `x + y`의 결과가 `int` 타입으로 변환되기 때문입니다. 따라서 `result`를 `int` 타입으로 선언해야 합니다.

#### 2. `int` 타입 변수가 피연산자로 사용된 경우

```java
int x = 10;
int y = 20;
int result = x + y; // 올바른 코드
```

`int` 타입의 변수는 연산 결과도 `int` 타입이므로, 별도의 변환 없이 바로 사용할 수 있습니다.

> byte 변수 x,y가 피연산자로 사용되면 int 타입으로 변환되어 연산되기 때문에 byte 연산자를 사용하면 컴파일 에러가 발생합니다

```java
int result = (byte) x + (byte) y; // => (int) x + (int) y
```

```java
package Variables;

public class ByteOperationExample {
    public static void main(String[] args) {
        byte result1 = 10 + 20;
        System.out.println(result1); // 30

        byte x = 10;
        byte y = 20;

        int result2 = x + y;
        System.out.println(result2); // 30
    }
}
```

단, 모든 정수 연산식에서 모든 변수가 `int` 타입으로 변환되는 것은 아닙니다. 두 피연산자 중 허용 범위가 더 큰 것을 따르게 됩니다.

```java
package Variables;

public class Longoperation {
    public static void main(String[] args) {
        byte value1 = 10;
        int value2 = 100;
        long value3 = 1000L;
        long result = value1 + value2 + value3;
        System.out.println(result); // 1110
    }
}
```

---

## 실수 연산에서의 자동 타입 변환

실수 타입 변수가 산술 연산식에서 피연산자로 사용될 경우 두 피연산자가 동일한 타입이라면 더 큰 범위 타입을 따르게 됩니다.

```java
int intValue = 10;
double doubleValue = 5.5;
double result = intValue + doubleValue; // 15.5, int 타입이 변경된다
```

```java
package sec03.exam05;

public class OperationsPromotionExample {
    public static void main(String[] args) {
        byte byteValue1 = 10;
        byte byteValue2 = 20;
        // byte byteValue3 = byteValue1 + byteValue2; // 컴파일 에러
        int intValue1 = byteValue1 + byteValue2;
        System.out.println(intValue1); // 30

        char charValue1 = 'A';
        char charValue2 = 1;
        // char charValue3 = charValue1 + charValue2; // 컴파일 에러
        int intValue2 = charValue1 + charValue2;
        System.out.println("유니코드=" + intValue2); // 유니코드 = 66
        System.out.println("출력문자=" + (char) intValue2); // 출력문자 = B

        int intValue3 = 10;
        int intValue4 = intValue3 / 4;
        System.out.println(intValue4); // 2

        int intValue5 = 10;
        // int intValue6 = 10 / 4.0; // 컴파일 에러
        double doubleValue = intValue5 / 4.0;
        System.out.println(doubleValue); // 2.5

        int x = 1;
        int y = 2;
        double result = (double) x / y;
        System.out.println(result); // 0.5
    }
}
```

---

## 실수 리터럴 연산

자바에서는 소문자 `f` 또는 대문자 `F`가 없는 실수 리터럴은 `double` 타입으로 해석됩니다. 그렇기 때문에 연산 결과는 `double` 타입 변수에 저장해야 합니다.

```java
double result = 1.5 + 2.3; // 올바른 코드
```

그러나 다음과 같이 `float` 타입 변수에 저장하면 컴파일 에러가 발생합니다:

```java
float result = 1.5 + 2.3; // 컴파일 에러 발생
```

`float` 타입에 꼭 저장하고 싶다면 실수 리터럴 뒤에 소문자 `f`나 대문자 `F`를 붙여 컴파일러가 `float` 타입임을 알도록 해야 합니다:

```java
float result = 1.5f + 2.3f; // 올바른 코드
```

---

## + 연산에서의 문자열 자동 타입 변환

자바에서 `+` 연산자는 두 가지 기능을 수행합니다: 덧셈 연산과 문자열 결합 연산입니다. 피연산자 중 하나가 문자열인 경우, 나머지 피연산자도 문자열로 변환되어 결합 연산이 수행됩니다.

### 연산 규칙 정리

1. **숫자와 숫자의 덧셈**
   - `숫자 + 숫자` → `덧셈 연산` → 결과: `숫자`

2. **문자열과 숫자의 결합**
   - `"문자열" + 숫자` → `"문자열" + "숫자"` → 결과: `"문자열숫자"`
   - `숫자 + "문자열"` → `"숫자" + "문자열"` → 결과: `"숫자문자열"`

### 예제 코드

- `int value = 3 + 7;`
  - 결과: `int value = 10;`

- `String str = "3" + 7;`
  - 결과: `String str = "3" + "7";` → 최종 결과: `String str = "37";`

- `String str = 3 + "7";`
  - 결과: `String str = "3" + "7";` → 최종 결과: `String str = "37";`

---

### 연산 예제

1. `int value = 1 + 2 + 3;`
   - 결과: `int value = 6;`

2. `String str = 1 + 2 + "3";`
   - 결과: `String str = "33";`

3. `String str = 1 + "2" + 3;`
   - 결과: `String str = "123";`

4. `String str = "1" + 2 + 3;`
   - 결과: `String str = "123";`

### 특정 부분을 우선 연산하고 싶은 경우

앞에서부터 숫자와 `+` 연산을 수행하지 않고 우선 연산하고 싶은 부분이 있다면 해당 부분을 괄호로 감싸면 됩니다. 괄호로 감싼 부분이 최우선으로 연산됩니다.

예제:
- `String str = "1" + (2 + 3);`
  - 결과: `String str = "1" + 5;`
  - 최종 결과: `String str = "15";`

```java
package Variables;

public class StringConcatExample {
    public static void main(String[] args) {
        // 숫자 연산
        int value = 10 + 2 + 8;
        System.out.println("value: " + value); // 20

        // 문자열 결합 연산자
        String str1 = 10 + 2 + "8";
        System.out.println("str1: " + str1); // 128

        String str2 = 10 + "2" + 8;
        System.out.println("str2: " + str2); // 1028

        String str3 = "10" + 2 + 8;
        System.out.println("str3: " + str3); // 1028

        String str4 = "10" + (2 + 8);
        System.out.println("str4: " + str4); // 1010
    }
}
```

## 문자열을 기본 타입으로 강제 타입 변환

다음은 문자열을 기본 타입으로 강제 타입 변환하는 방법입니다.

| 변환 타입          | 사용 예                                 |
|------------------|--------------------------------------|
| String → byte    | String str = "10";                    |
|                  | byte value = Byte.parseByte(str);     |
| String → short   | String str = "200";                   |
|                  | short value = Short.parseShort(str);  |
| String → int     | String str = "300000";                |
|                  | int value = Integer.parseInt(str);    |
| String → long    | String str = "4000000000";            |
|                  | long value = Long.parseLong(str);     |
| String → float   | String str = "12.345";                |
|                  | float value = Float.parseFloat(str);  |
| String → double  | String str = "12.345";                |
|                  | double value = Double.parseDouble(str);|
| String → boolean | String str = "true";                  |
|                  | boolean value = Boolean.parseBoolean(str);|

문자열을 기본 타입으로 변환할 때, 변환할 문자열이 해당 타입의 형식에 맞지 않으면 `NumberFormatException` 오류가 발생할 수 있습니다.

```java
String str = "la";
int value = Integer.parseInt(str); // 문자열이 숫자가 아니거나 잘못되면 오류 발생
```

기본 타입 값을 문자열로 변환할 때는 `String.valueOf(기본타입값)`을 사용합니다. 예를 들어, `String.valueOf(3)`은 문자열 `"3"`을 반환합니다.

```java
package Variables;

public class PrimitiveAndStringConversion {
    public static void main(String[] args) {
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");

        System.out.println("value1: " + value1); // 10
        System.out.println("value2: " + value2); // 3.14
        System.out.println("value3: " + value3); // true

        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);

        System.out.println("str1: " + str1); // 10
        System.out.println("str2: " + str2); // 3.14
        System.out.println("str3: " + str3); // true
    }
}
```
