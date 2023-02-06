package jp.co.careritztc.day3.answer2;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import jp.co.careritztc.day3.exercise2.pojo.Employee;

/**
 * Javaの基礎５日間コース ３日目.
 *
 * <pre>
 * 演習問題２-１プログラム起動クラス
 * </pre>
 */
public class Exercise21Main {

  private static final List<String> EMPLOYEES = loadData();

  private static final String TITLE_STRING = "｜First Name｜Last Name｜名｜姓｜";
  private static final String ROW_STRING = "｜%s｜%s｜%s｜%s｜";

  /**
   * main.
   */
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();

    for (String employee : EMPLOYEES) {
      var rowdata = employee.split(",");
      employees.add(new Employee(rowdata[0], rowdata[1], rowdata[2], rowdata[3]));
    }

    System.out.println("解答例１");
    System.out.println("---------");
    example1(employees);
    System.out.println("---------");

    System.out.println("===========================");

    System.out.println("解答例２");
    System.out.println("---------");
    example2(employees);
    System.out.println("---------");

  }

  /**
   * テキストファイルから従業員リストをLoadして返す.
   *
   * @return 従業員リスト(immutable)
   */
  private static List<String> loadData() {
    try {
      Path path = Path.of(ClassLoader.getSystemClassLoader()
                                     .getResource("jp/co/careritztc/day3/answer2/data/employees.csv")
                                     .toURI());
      return List.of(Files.readString(path)
                          .split("\n"));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private static void example1(List<Employee> employees) {
    StringBuilder builder = new StringBuilder(TITLE_STRING);
    builder.append("\n");

    for (Employee employee : employees) {
      builder.append(
          ROW_STRING.formatted(employee.firstName, employee.lastName, employee.jaFirstName, employee.jaLastName))
             .append("\n");
    }

    System.out.println(builder.toString());
  }

  private static void example2(List<Employee> employees) {
    System.out.println(TITLE_STRING);
    employees.forEach(
        e -> System.out.println(ROW_STRING.formatted(e.firstName, e.lastName, e.jaFirstName, e.jaLastName)));
  }
}
