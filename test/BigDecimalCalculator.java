package test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

public class BigDecimalCalculator {
    private static final int DEFAULT_SCALE = 10;
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_UP;

    static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

    public BigDecimal add(String a, String b) {
        BigDecimal num1 = parse(a);
        BigDecimal num2 = parse(b);
        return num1.add(num2);
    }

    // 뺄셈: a - b
    public BigDecimal subtract(String a, String b) {
        BigDecimal num1 = parse(a);
        BigDecimal num2 = parse(b);
        return num1.subtract(num2);
    }

    // 곱셈: a * b
    public BigDecimal multiply(String a, String b) {
        BigDecimal num1 = parse(a);
        BigDecimal num2 = parse(b);
        return num1.multiply(num2);
    }

    // 나눗셈: a / b (무한 소수 순환 및 0 나누기 방어)
    public BigDecimal divide(String a, String b) {
        return divide(a, b, DEFAULT_SCALE, DEFAULT_ROUNDING);
    }

    public BigDecimal divide(String a, String b, int scale, RoundingMode roundingMode) {
        BigDecimal num1 = parse(a);
        BigDecimal num2 = parse(b);

        if (num2.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        // 스케일과 반올림 모드를 지정해 1/3 같은 무한소수 연산 시 ArithmeticException 방지
        return num1.divide(num2, scale, roundingMode);
    }

    // 거듭제곱: a^exponent (실수 오버플로우 방지)
    public BigDecimal power(String base, int exponent) {
        BigDecimal num = parse(base);
        // MathContext를 넘겨 유효숫자를 관리하면서 거듭제곱
        return num.pow(exponent, MATH_CONTEXT);
    }

    // 나머지 연산: a % b
    public BigDecimal remainder(String a, String b) {
        BigDecimal num1 = parse(a);
        BigDecimal num2 = parse(b);

        if (num2.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("0으로 나눈 나머지를 구할 수 없습니다.");
        }

        return num1.remainder(num2);
    }

    private BigDecimal parse(String val) {
        Objects.requireNonNull(val, "입력값은 null일 수 없습니다.");
        try {
            return new BigDecimal(val.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다: " + val, e);
        }
    }
}
