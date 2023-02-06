package jp.co.careritztc.day3.answer1.pojo;

import java.time.LocalDate;

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
  /** 氏. */
  private String lastName;
  /** 性別. */
  private Gender gender;
  /** 給与. */
  private Integer salary;
  /** 誕生日. */
  private LocalDate birthday;

  /**
   * コンストラクタ.
   *
   * @param firstName 名
   * @param lastName  姓
   * @param gender    性別
   * @param salary    給与
   * @param birthday  誕生日
   */
  public Staff(String firstName, String lastName, Gender gender, Integer salary, LocalDate birthday) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.salary = salary;
    this.birthday = birthday;
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

  public LocalDate getBirthday() {
    return birthday;
  }
}
