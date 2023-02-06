package jp.co.careritztc.day3.answer2;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import jp.co.careritztc.day3.answer2.pojo.Employee;

/**
 * Javaの基礎５日間コース ３日目.
 *
 * <pre>
 * 演習問題２-４プログラム起動クラス
 * </pre>
 */
public class Exercise24Main {

  private static final List<String> EMPLOYEES = loadData();

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
    StringBuilder builder = new StringBuilder();

    int count = 0;
    for (Employee employee : employees) {
      if (employee.jaFirstName.contains("郎")) {
        count++;
        builder.append(employee.jaLastName);
        builder.append("\n");
      }
    }

    System.out.println("%d人".formatted(count));
    System.out.println(builder.toString());
  }

  private static void example2(List<Employee> employees) {
    long count = employees.stream()
                          .filter(e -> e.jaFirstName.contains("郎"))
                          .count();
    System.out.println("%d人".formatted(count));
    employees.stream()
             .filter(e -> e.jaFirstName.contains("郎"))
             .forEach(e -> System.out.println(e.jaLastName));
  }

}
