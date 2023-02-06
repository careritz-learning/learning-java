package jp.co.careritztc.day3.answer1;

import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import jp.co.careritztc.day3.answer1.data.ExampleTypeMap;
import jp.co.careritztc.day3.answer1.pojo.Staff;

/**
 * Javaの基礎５日間コース ３日目.
 *
 * <pre>
 * 演習問題１-４プログラム起動クラス
 * </pre>
 */
public class Exercise14Main {

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
    Set<LocalDate> hashSet = new HashSet<>();
    for (Staff staff : staffs) {
      hashSet.add(staff.getBirthday()
                       .withYear(2020));
    }

    // 全員の誕生日を年を除いたMM月dd日形式で重複を排除した形で標準出力へ表示
    TreeSet<LocalDate> sortedSet = new TreeSet<>(hashSet);
    for (LocalDate date : sortedSet.descendingSet()) {
      var lineFormatter = DateTimeFormatter.ofPattern("MM月dd日", Locale.JAPAN);
      System.out.println(
          "%s".formatted(lineFormatter.format(JapaneseDate.from(date))));
    }
  }

  private static void example2(Map<String, Staff> data) {

    // 全員の誕生日を年を除いたMM月dd日形式で重複を排除した形で標準出力へ表示
    List<LocalDate> sortedList = data.values()
                                     .stream()
                                     .map(Staff::getBirthday)
                                     .map(date -> date.withYear(2020))
                                     .distinct()
                                     .sorted(Comparator.reverseOrder())
                                     .collect(Collectors.toList());

    Function<LocalDate, String> funcLineFormatter = date -> "%s".formatted(
        DateTimeFormatter.ofPattern("MM月dd日", Locale.JAPAN)
                         .format(JapaneseDate.from(date)));
    sortedList.stream()
              .map(funcLineFormatter::apply)
              .forEach(System.out::println);
  }
}
