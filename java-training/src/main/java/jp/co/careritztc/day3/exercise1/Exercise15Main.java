package jp.co.careritztc.day3.exercise1;

import java.util.Map;
import java.util.Scanner;
import jp.co.careritztc.day3.exercise1.data.ExampleTypeMap;
import jp.co.careritztc.day3.exercise1.pojo.Staff;

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

      // TODO
      // 標準入力から年月日指定し、1995-02-14生まれの人の**人数**を標準出力へ表示して下さい。
      // また、標準入力から本日または無効な年月日を指定した場合は、**0**（ゼロ）が表示されるようにして下さい。

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
