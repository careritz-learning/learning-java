package jp.co.careritztc.game;

import jp.co.careritztc.game.character.GameCharacter;
import jp.co.careritztc.game.character.impl.God;
import jp.co.careritztc.game.character.impl.Human;
import jp.co.careritztc.game.chat.impl.GlobalChat;
import jp.co.careritztc.game.chat.impl.GuildChat;

/**
 * ゲームSample.
 *
 * <pre>
 * 実行方法：./gradlew :oop-sample:run
 * </pre>
 */
public class OopSample {
  public static void main(String[] args) {
    System.out.println("Game Start.");
    // OopSampleクラスのインスタンスを生成し、OopSample型の変数oopへ代入
    OopSample oop = new OopSample();

    GameCharacter charaA = new God("神様");
    GameCharacter charaB = new Human("人間");

    charaA.sendMessage("敬いたまへ。This is a pen.", GlobalChat.TYPE);
    charaB.sendMessage("神はタヒんだ。This is a pen.", GuildChat.TYPE);

    // 攻撃結果文字列を取得し、String型の変数attackResultへ代入
    String attackResult = oop.getAttackResult(charaA, charaB);
    System.out.println(attackResult);
  }

  /**
   * 攻撃結果を返す.
   *
   * @return 攻撃結果文字列
   */
  // インスタンスメソッド（staticでない）
  public String getAttackResult(GameCharacter charaA, GameCharacter charaB) {
    return String.format("Attack Score %s：[%d] vs %s：[%d]",
        charaA.getClass()
              .getSimpleName(),
        charaA.attack(),
        charaB.getClass()
              .getSimpleName(),
        charaB.attack());
  }
}
