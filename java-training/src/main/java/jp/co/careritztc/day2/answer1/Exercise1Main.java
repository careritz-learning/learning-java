package jp.co.careritztc.day2.answer1;

import java.math.BigDecimal;

/**
 * Javaの基礎５日間コース ３日目.
 *
 * <pre>
 * 演習問題１プログラム起動クラス
 * </pre>
 */
public class Exercise1Main {

  /**
   * main method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    System.out.println("primitiveのdoubleで計算した場合");
    ans1();

    System.out.println("=======================");

    System.out.println("BigDecimalを使用した場合");
    ans2();

    ans3();
  }

  static void ans1() {
    // 増分
    double diff = 0.1d;

    double result = 0.0d;
    for (int i = 0; i < 10; i++) {
      result += diff;
      System.out.println("i=%d result=".formatted(i) + result);
    }
  }

  static void ans2() {
    BigDecimal diff = BigDecimal.valueOf(0.1d);

    BigDecimal result = BigDecimal.valueOf(0.0d);
    for (int i = 0; i < 10; i++) {
      // BigDecimalはイミュータブルなクラスです
      result = result.add(diff);
      System.out.println("i=%d result=".formatted(i) + result.doubleValue());
    }
  }

  static void ans3() {
    var reason = """
        まず、Javaにおける`double`型はIEEE 754 規格に沿い、有限桁のフォーマットで 2 進浮動小数点数を表現します。
        ここで、2進数演算の際に循環し、有限桁で表現出来ない場合に誤差が発生します。
        BigDecimalにおいては、scaleや端数処理ポリシーによってこの問題を緩和しています。
        もし詳細に興味のある人は、BigDecimalのJavadocを参照してみて下さい。
        """;
    System.out.println("例）");
    System.out.println(reason);
    double[] example = { 0.1d, 0.2d, 0.3d };
    System.out.println("       0.1d: " + Long.toBinaryString(Double.doubleToRawLongBits(example[0])));
    System.out.println("       0.2d: " + Long.toBinaryString(Double.doubleToRawLongBits(example[1])));
    System.out.println("       0.3d: " + Long.toBinaryString(Double.doubleToRawLongBits(example[2])));
    System.out.println("0.1d + 0.2d: " + Long.toBinaryString(Double.doubleToRawLongBits(example[0] + example[1])));
  }
}
