package jp.co.careritztc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Hello MySQL.
 */
public class HelloMysql {

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
  // ※データベース名が「ORCL」でない場合は該当の箇所を変更してください
  private static final String JDBC_URL;

  static {
    StringBuilder builder = new StringBuilder();
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

    String sql = "SELECT sysdate() as sysdate FROM DUAL";

    // Java8から導入されているtry-with-resourcesと呼ばれる書き方です。
    try (
        /*---------------------------------------------*
             * ②接続の確立（Connectionオブジェクトの取得）
         *---------------------------------------------*/
        Connection con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
        // PreparedStatementオブジェクトを生成＆発行するSQLをセット
        PreparedStatement ps = con.prepareStatement(sql);
        /*------------------------------------------------------*
         * ③SQL文の送信 ＆ ④抽出結果（ResultSetオブジェクト）の取得
         *------------------------------------------------------*/
        ResultSet rs = ps.executeQuery();) {

      System.out.println(String.format("AutoCommit is %b", con.getAutoCommit()));

      // ResultSetオブジェクトから1レコードずつデータを取得＆加工＆表示する
      while (rs.next()) {
        // 1レコード分のデータを取得＆加工（各カラムをタブ区切りで結合）
        StringBuilder rssb = new StringBuilder();
        // rssb.append(rs.getString("SYSDATE"));
        rssb.append(rs.getObject("SYSDATE", LocalDateTime.class));

        // 加工作成した1レコード分のデータを出力
        System.out.println(rssb.toString());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
