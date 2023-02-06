package jp.co.careritztc.game.chat.impl;

import jp.co.careritztc.game.chat.Chat;
import jp.co.careritztc.game.chat.Translation;

/**
 * Globalチャットクラス.
 */
public class GlobalChat implements Chat, Translation {
  public static final String TYPE = "GLOBAL";

  private Translation translation;

  /**
   * コンストラクタ.
   */
  public GlobalChat() {
    // Translationを使った無名クラスではなく、ラムダ式による型推論を使った記述例
    // デフォルト翻訳（引数のメッセージ中に"This is a pen."があった場合、"これはペンです。"に置換して返す）。
    this(message -> message.replace("This is a pen.", "これはペンです。"));
  }

  /**
   * コンストラクタ.
   *
   * @param translation 翻訳
   */
  public GlobalChat(Translation translation) {
    this.translation = translation;
  }

  @Override
  public void sendMessage(String message) {
    System.out.println("%s: %s".formatted(TYPE, translate(message)));
  }

  @Override
  public String translate(String message) {
    return translation.translate(message);
  }
}
