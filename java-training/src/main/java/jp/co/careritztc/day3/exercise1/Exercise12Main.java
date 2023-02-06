package jp.co.careritztc.day3.exercise1;

import java.util.Map;
import jp.co.careritztc.day3.exercise1.data.ExampleTypeMap;
import jp.co.careritztc.day3.exercise1.pojo.Staff;

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

    // TODO 生年月日の**早い順**に、姓と誕生日を**和暦**で標準出力へ表示して下さい。
  }
}
