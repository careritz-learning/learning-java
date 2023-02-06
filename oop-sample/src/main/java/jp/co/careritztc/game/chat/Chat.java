package jp.co.careritztc.game.chat;

/**
 * チャットインターフェース.
 */
public interface Chat {

  /**
   * チャットへメッセージ送信する.
   *
   * @param message 送信メッセージ
   */
  public void sendMessage(String message);
}
