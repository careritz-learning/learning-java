
public class Third {

  public void foo() {
    System.out.println("instance method foo Third");

    bar(); // `this.`の記述は省略可能
  }

  public void bar() {
    System.out.println("instance method bar Third");

    // superは呼び出し元でなく親クラスを指し示す
    System.out.println("toString() return " + super.toString());
    System.out.println("toString() return " + new Object().toString());

    // baz()はstaticメソッドなのでインスタンスを介しての実行は警告される
    // this.baz();

    // Third.baz();と記載するのと同じ。
    // 同一クラス内のメソッドなので`Third.`の記述は不要
    baz();
  }

  public static void baz() {
    System.out.println("static method baz Third");

    First first = new First();
    first.foo();
    First.bar(); // staticメソッドの呼び出しにはインスタンス不要

    // staticメソッドから`super.`の記述は出来ません
  }

  @Override
  public String toString() {
    return "This is Third Class.";
  }
}
