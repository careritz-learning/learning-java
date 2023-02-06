package jp.co.careritztc.game.chat;

/**
 * 翻訳インターフェース.
 */
public interface Translation {

  /**
   * 翻訳する.
   *
   * @param message メッセージ
   * @return 翻訳後メッセージ
   */
  public String translate(String message);
}
