package jp.co.careritztc.game.character;

import java.util.HashMap;
import java.util.Map;
import jp.co.careritztc.game.chat.Chat;
import jp.co.careritztc.game.chat.impl.GlobalChat;
import jp.co.careritztc.game.chat.impl.GuildChat;
import jp.co.careritztc.game.model.Item;
import jp.co.careritztc.game.tools.ToolBox;

/**
 * ゲームキャラクタークラス.
 */
public abstract class GameCharacter {
  // キャラクター名
  private String name;
  private Map<String, Chat> chats;
  private ToolBox toolBox;

  /**
   * コンストラクタ.
   *
   * @param name キャラクター名
   */
  protected GameCharacter(String name) {
    Map<String, Chat> initChats = new HashMap<>();
    initChats.put(GlobalChat.TYPE, new GlobalChat());
    initChats.put(GuildChat.TYPE, new GuildChat());

    this.name = name;
    this.chats = initChats;
    // ToolBox機能の実装（無名クラスの記法サンプル）
    this.toolBox = new ToolBox() {
      @Override
      public void useItem(Item item) {
        // TODO Auto-generated method stub
      }
    };
  }

  /**
   * 名前を取得する.
   */
  public String getName() {
    return name;
  }

  /**
   * メッセージを送信する.
   *
   * @param message  送信メッセージ
   * @param chatType チャットタイプ
   */
  public void sendMessage(String message, String chatType) {
    chats.get(chatType)
         .sendMessage(message);
  }

  /**
   * アイテムを使用する.
   *
   * @param item 使用するアイテム
   */
  public void useItem(Item item) {
    toolBox.useItem(item);
  }

  /**
   * 攻撃し、ダメージ量を返す.
   *
   * @return ダメージ量
   */
  public abstract Integer attack();

  /**
   * 逃走し、逃走結果としての成否を返す.
   *
   * @param speed 逃走スピード
   * @return 逃走結果としての成否
   */
  public abstract Boolean runaway(int speed);
}
