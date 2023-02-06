package jp.co.careritztc.game.chat.impl;

import jp.co.careritztc.game.chat.Chat;

/**
 * ギルドチャットクラス.
 */
public class GuildChat implements Chat {
  public static final String TYPE = "GUILD";

  @Override
  public void sendMessage(String message) {
    System.out.println("%s: %s".formatted(TYPE, message));
  }
}
