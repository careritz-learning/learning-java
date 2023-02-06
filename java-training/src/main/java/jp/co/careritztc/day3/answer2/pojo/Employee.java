package jp.co.careritztc.day3.answer2.pojo;

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

  /**
   * コンストラクタ.
   *
   * @param obj Employee
   */
  public Employee(Employee obj) {
    this.firstName = obj.firstName;
    this.lastName = obj.lastName;
    this.jaFirstName = obj.jaFirstName;
    this.jaLastName = obj.jaLastName;
  }
}
