package jp.co.careritztc.day3.answer1;

import java.time.Year;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import jp.co.careritztc.day3.answer1.data.ExampleTypeMap;
import jp.co.careritztc.day3.answer1.pojo.Staff;

/**
 * Javaの基礎５日間コース ３日目.
 *
 * <pre>
 * 演習問題１-３プログラム起動クラス
 * </pre>
 */
public class Exercise13Main {

  /**
   * main method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    // key:氏名, value:Staff
    Map<String, Staff> data = ExampleTypeMap.getSampleData();

    System.out.println("解答例１");
    System.out.println("---------");
    example1(data);
    System.out.println("---------");

    System.out.println("===========================");

    System.out.println("解答例２");
    System.out.println("---------");
    example2(data);
    System.out.println("---------");
  }

  private static void example1(Map<String, Staff> data) {
    List<Staff> staffs = new ArrayList<>(data.values());

    // 氏名と、今年の誕生日に加え、その曜日を標準出力へ表示
    for (Staff staff : staffs) {
      var lineFormatter = DateTimeFormatter.ofPattern("Gy年M月d日(EEEE)", Locale.JAPAN);
      // 今年の誕生日
      var birthdayOfThisYear = Year.now()
                                   .atMonth(staff.getBirthday()
                                                 .getMonth())
                                   .atDay(staff.getBirthday()
                                               .getDayOfMonth());
      System.out.println(
          "%s %s %s".formatted(staff.getLastName(), staff.getFirstName(),
              lineFormatter.format(JapaneseDate.from(birthdayOfThisYear))));
    }
  }

  private static void example2(Map<String, Staff> data) {

    List<Staff> staffs = data.values()
                             .stream()
                             .collect(Collectors.toList());

    // 氏名と、今年の誕生日に加え、その曜日を標準出力へ表示
    Function<Staff, String> funcLineFormatter = staff -> "%s %s %s".formatted(staff.getLastName(),
        staff.getFirstName(),
        DateTimeFormatter.ofPattern("Gy年M月d日(EEEE)", Locale.JAPAN)
                         .format(JapaneseDate.from(Year.now()
                                                       .atMonth(staff.getBirthday()
                                                                     .getMonth())
                                                       .atDay(staff.getBirthday()
                                                                   .getDayOfMonth()))));
    staffs.stream()
          .map(funcLineFormatter::apply)
          .forEach(System.out::println);
  }
}
