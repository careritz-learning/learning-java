package jp.co.careritztc.day3.answer1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import jp.co.careritztc.day3.answer1.data.ExampleTypeMap;
import jp.co.careritztc.day3.answer1.pojo.Staff;

/**
 * Javaの基礎５日間コース ３日目.
 *
 * <pre>
 * 演習問題１-５プログラム起動クラス
 * </pre>
 */
public class Exercise15Main {

  /**
   * main method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    // key:氏名, value:Staff
    Map<String, Staff> data = ExampleTypeMap.getSampleData();

    try (var scanner = new Scanner(System.in)) {
      String line = scanner.nextLine();
      System.out.println("入力値[%s]".formatted(line));
      LocalDate inputDate = LocalDate.parse(line);

      System.out.println("解答例１");
      System.out.println("---------");
      example1(inputDate, data);
      System.out.println("---------");

      System.out.println("===========================");

      System.out.println("解答例２");
      System.out.println("---------");
      example2(inputDate, data);
      System.out.println("---------");

    } catch (DateTimeParseException dtpe) {
      // 標準入力から無効な年月日を指定した場合は、0（ゼロ）を表示
      System.out.println("0");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void example1(LocalDate inputDate, Map<String, Staff> data) {

    List<Staff> staffs = new ArrayList<>(data.values());
    List<LocalDate> birthdays = new ArrayList<>();
    for (Staff staff : staffs) {
      birthdays.add(staff.getBirthday());
    }
    int count = Collections.frequency(birthdays, inputDate);

    System.out.println(count);
  }

  private static void example2(LocalDate inputDate, Map<String, Staff> data) {

    long count = data.values()
                     .stream()
                     .map(Staff::getBirthday)
                     .filter(date -> date.isEqual(inputDate))
                     .count();

    System.out.println(count);
  }
}
