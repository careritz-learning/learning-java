package jp.co.careritztc.day3.exercise1.pojo;

/**
 * Staffクラス.
 */
public class Staff {

  /**
   * 性別のEnum定義.
   */
  public enum Gender {
    MALE,
    FEMALE,
    ;
  }

  /** 名. */
  private String firstName;
  /** 姓. */
  private String lastName;
  /** 性別. */
  private Gender gender;
  /** 給与. */
  private Integer salary;

  /**
   * コンストラクタ.
   *
   * @param firstName 名
   * @param lastName  氏
   * @param gender    性別
   * @param salary    給与
   */
  public Staff(String firstName, String lastName, Gender gender, Integer salary) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.salary = salary;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public Integer getSalary() {
    return salary;
  }
}
