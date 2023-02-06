package jp.co.careritztc.day2.answer2.pojo;

import java.time.LocalDate;

public class Staff {

  public enum Gender {
    MALE,
    FEMALE,
    ;
  }

  private String firstName;
  private String lastName;
  private Gender gender;
  private Integer salary;
  private LocalDate birthday;

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
