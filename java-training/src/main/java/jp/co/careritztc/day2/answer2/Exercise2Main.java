package jp.co.careritztc.day2.answer2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import jp.co.careritztc.day2.answer2.data.ExampleTypeMap;
import jp.co.careritztc.day2.answer2.pojo.Staff;
import jp.co.careritztc.day2.answer2.pojo.Staff.Gender;

/**
 * Javaの基礎５日間コース ２日目.
 *
 * <pre>
 * 演習問題２プログラム起動クラス
 * </pre>
 */
public class Exercise2Main {
  private static final Map<String, Staff> staffs = ExampleTypeMap.getSampleData();
  // 136円45銭/1ドル
  private static final double FIX_RATE_YEN_DOLLAR = 136.45d;

  /**
   * main method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    System.out.println("演習問題２-１、２-２");
    exercise21();

    System.out.println("========================");

    System.out.println("演習問題２-３");
    exercise23();

    System.out.println("========================");

    System.out.println("演習問題２-４");
    exercise24();
  }

  static void exercise21() {
    for (Entry<String, Staff> entry : staffs.entrySet()) {
      String fullName = entry.getKey();
      Staff staff = staffs.get(fullName);
      System.out.println("氏名:[%s] 性別:[%s] 給与：[%d]円".formatted(fullName, staff.getGender(), staff.getSalary()));
    }
  }

  static void exercise23() {
    System.out.println("女性（`Gender.FEMALE`）についてのみを標準出力");
    System.out.println("-------------");
    printOnlyFemales();
    System.out.println("=============");
    System.out.println("男性（`Gender.MALE`）についてのみを標準出力");
    System.out.println("-------------");
    printOnlyMales();
  }

  static void exercise24() {
    double avgSalary = getAverageSalary();
    System.out.println(String.format("平均給与は%.0f円です。", avgSalary));
    System.out.println(String.format("平均給与は%.2fドルです。", toDollar(avgSalary)));
  }

  private static void printOnlyFemales() {
    for (var entry : staffs.entrySet()) {
      Staff staff = entry.getValue();
      if (Gender.FEMALE == staff.getGender()) {
        System.out.println("氏名:[%s] 給与：[%d]円".formatted(entry.getKey(), staff.getSalary()));
      }
    }
  }

  private static void printOnlyMales() {
    staffs.entrySet()
          .stream()
          .filter(entry -> Gender.MALE == entry.getValue()
                                               .getGender())
          .forEach(entry -> System.out.println(
              "氏名:[%s] 給与：[%d]円".formatted(
                  entry.getKey(),
                  entry.getValue()
                       .getSalary())));
  }

  private static double getAverageSalary() {
    return staffs.values()
                 .stream()
                 .mapToInt(Staff::getSalary)
                 .average()
                 .orElse(0.0d);
  }

  private static double toDollar(double yen) {
    BigDecimal rate = BigDecimal.valueOf(FIX_RATE_YEN_DOLLAR);
    // divide(BigDecimal divisor)メソッドを使用した場合、
    // 小数点以下が無限となるために正確な商を表現できない場合にArithmeticExceptionがスローされます。
    // また、今回rateは固定ですが、ゼロで割ろうとした場合もArithmeticExceptionがスローされます。
    // 有効桁数は小数点以下第2位までとして計算。
    return BigDecimal.valueOf(yen)
                     .divide(rate, 3, RoundingMode.DOWN)
                     .doubleValue();
  }
}
