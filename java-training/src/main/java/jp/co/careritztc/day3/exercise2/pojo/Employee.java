package jp.co.careritztc.day3.exercise2.pojo;

/**
 * Employee.
 */
public class Employee {
  public String firstName;
  public String lastName;
  public String jaFirstName;
  public String jaLastName;

  /**
   * コンストラクタ.
   *
   * @param firstName   first name
   * @param lastName    last name
   * @param jaFirstName 名
   * @param jaLastName  姓
   */
  public Employee(String firstName, String lastName, String jaFirstName, String jaLastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.jaFirstName = jaFirstName;
    this.jaLastName = jaLastName;
  }
}
