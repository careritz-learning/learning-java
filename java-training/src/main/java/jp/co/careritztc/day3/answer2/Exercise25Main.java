package jp.co.careritztc.day3.answer2;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import jp.co.careritztc.day3.answer2.pojo.Employee;

/**
 * Javaの基礎５日間コース ３日目.
 *
 * <pre>
 * 演習問題２-５プログラム起動クラス
 * </pre>
 */
public class Exercise25Main {

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

  private static void saveData(List<Employee> sortedList) {
    try {
      StringBuilder builder = new StringBuilder();
      for (Employee employee : sortedList) {
        builder.append("%s,%s,%s,%s".formatted(employee.firstName, employee.lastName,
            employee.jaFirstName, employee.jaLastName));
        builder.append("\n");
      }

      Files.writeString(Paths.get("employees2.csv"), builder.toString(), CREATE, TRUNCATE_EXISTING, WRITE);
      System.out.println(builder.toString());
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private static void example1(List<Employee> employees) {
    // List<Employee> sortedList = new ArrayList<>(employees);
    // 上記例ではImmutableでないEmployeeオブジェクトは複製して詰め直す訳では無い事に注意.
    List<Employee> sortedList = new ArrayList<>(employees.size());
    for (Employee employee : employees) {
      sortedList.add(new Employee(employee));
    }
    // Last Nameの昇順に並べ替え
    sortedList.sort(new Comparator<Employee>() {
      @Override
      public int compare(Employee arg0, Employee arg1) {
        return arg0.lastName.compareTo(arg1.lastName);
      }
    });
    for (Employee employee : sortedList) {
      employee.jaFirstName = employee.jaFirstName.replace("健", "堅");
    }

    saveData(sortedList);
  }

  private static void example2(List<Employee> employees) {
    Comparator<Employee> comparator = (employee1, employee2) -> employee1.lastName.compareTo(employee2.lastName);
    UnaryOperator<Employee> funcRename = (e -> {
      e.jaFirstName = e.jaFirstName.replace("健", "堅");
      return e;
    });
    List<Employee> sortedList = employees.stream()
                                         .sorted(comparator)
                                         .map(funcRename)
                                         .toList();
    saveData(sortedList);
  }

}
