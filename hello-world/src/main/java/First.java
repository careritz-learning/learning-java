public class First {
  public static void main(String[] args) {
    System.out.println("start First");

    Second second = new Second();
    second.foo();
  }

  public void foo() {
    System.out.println("instance method foo First");
  }

  public static void bar() {
    System.out.println("static method bar First");
  }
}
