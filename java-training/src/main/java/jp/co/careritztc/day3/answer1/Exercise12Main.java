package jp.co.careritztc.day3.answer1;

import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 * 演習問題１-２プログラム起動クラス
 * </pre>
 */
public class Exercise12Main {

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
    List<Staff> sortedList = new ArrayList<>(data.values());
    Collections.sort(sortedList, new Comparator<Staff>() {
      @Override
      public int compare(Staff arg0, Staff arg1) {
        // 生年月日の早い順でソート
        Long diff = ChronoUnit.DAYS.between(arg1.getBirthday(), arg0.getBirthday());

        return diff.intValue();
      }
    });

    // 姓と誕生日を和暦で標準出力へ表示
    for (Staff staff : sortedList) {
      var lineFormatter = DateTimeFormatter.ofPattern("Gy年M月d日", Locale.JAPAN);
      System.out.println(
          "%s %s".formatted(staff.getLastName(), lineFormatter.format(JapaneseDate.from(staff.getBirthday()))));
    }
  }

  private static void example2(Map<String, Staff> data) {

    List<Staff> sortedList = data.values()
                                 .stream()
                                 .sorted(Comparator.comparing(Staff::getBirthday))
                                 .collect(Collectors.toList());

    // 姓と誕生日を和暦で標準出力へ表示
    Function<Staff, String> funcLineFormatter = staff -> "%s %s".formatted(staff.getLastName(),
        DateTimeFormatter.ofPattern("Gy年M月d日", Locale.JAPAN)
                         .format(JapaneseDate.from(staff.getBirthday())));
    sortedList.stream()
              .map(funcLineFormatter::apply)
              .forEach(System.out::println);
  }
}
