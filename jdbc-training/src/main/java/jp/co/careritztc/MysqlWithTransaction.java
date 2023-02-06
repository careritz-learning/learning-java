package jp.co.careritztc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * MySQL with Transaction.
 */
public class MysqlWithTransaction {

  /*-----------------------------*
   * データベースへの接続情報
   *-----------------------------*/
  // 接続するユーザー名
  // ※ユーザー名が「training」でない場合は該当箇所を変更してください
  private static final String USER_ID = "training";

  // 接続するユーザーのパスワード
  // ※パスワードが「passwd」でない場合は該当箇所を変更してください
  private static final String USER_PASS = "passwd";

  // 接続先DB
  private static final String JDBC_URL;

  static {
    StringBuilder builder = new StringBuilder();
    // ※PORT番号「3306」、データベース名が「training」でない場合は該当の箇所を変更してください
    builder.append("jdbc:mysql://localhost:3306/training")
           .append("?characterEncoding=UTF-8")
           .append("&connectionTimeZone=SERVER");
    JDBC_URL = builder.toString();
  }

  /**
   * main.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    /*-----------------------------*
     * ① JDBCドライバの存在チェック
     *-----------------------------*/
    DriverManager.drivers()
                 .forEach(System.out::println);

    // SQL文（DML）を定義
    String sqlEmployeeTraining = "update employee_training set division_cd=? where employee_id=?";
    String sqlDivisionTraining = "update division_training set division_name=? where division_cd=?";

    /*---------------------------------------------*
         * ②接続の確立（Connectionオブジェクトの取得）
     *---------------------------------------------*/
    try (Connection con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS)) {

      // AutoCommitの無効化（デフォルトは有効）
      con.setAutoCommit(false);
      System.out.println(String.format("AutoCommit is %b", con.getAutoCommit()));

      // PreparedStatementオブジェクトを生成＆発行するSQLをセット
      // tryブロックのネストはあまりよろしくないが、rollback()がSQLExceptionをthrowするのがポイント。
      // ネストを避けるにはメソッド分割など機能の部品化が必要だが研修プログラムなので省略。
      try (PreparedStatement psEmployeeTraining = con.prepareStatement(sqlEmployeeTraining);
          PreparedStatement psDivisionTraining = con.prepareStatement(sqlDivisionTraining);) {
        /*-----------------------*
         * ③バインド変数のセット
         *-----------------------*/
        psEmployeeTraining.setString(1, "SALES"); // division_cd
        psEmployeeTraining.setInt(2, 20); // employee_id

        psDivisionTraining.setString(1, "IT営業部");
        psDivisionTraining.setString(2, "SALES");

        /*-----------------------*
         * ④SQL文の送信
         *-----------------------*/
        psEmployeeTraining.executeUpdate();
        psDivisionTraining.executeUpdate();

        // 対象のSQLが全て正常実行されたらcommit
        con.commit();

        System.out.println("Success Updated.");

      } catch (SQLException e) {
        // SQL実行に失敗したらrollbackする
        con.rollback();

        System.err.println("failed executeUpdate.");
        throw e;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
