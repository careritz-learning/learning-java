public class Second {

  public void foo() {
    System.out.println("instance method foo Second");

    this.bar(); // `this.`の記述は省略可能
  }

  public void bar() {
    System.out.println("instance method bar Second");

    Third third = new Third();
    third.foo();
  }
}
