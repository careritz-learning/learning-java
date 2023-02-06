package jp.co.careritztc.day3.exercise1;

import java.util.Map;
import jp.co.careritztc.day3.exercise1.data.ExampleTypeMap;
import jp.co.careritztc.day3.exercise1.pojo.Staff;

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

    // TODO 全員の氏名と、今年の誕生日に加え、その曜日を標準出力へ表示して下さい。
  }
}
