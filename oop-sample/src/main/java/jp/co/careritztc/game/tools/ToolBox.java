package jp.co.careritztc.game.tools;

import jp.co.careritztc.game.model.Item;

/**
 * 道具箱インターフェース.
 */
public interface ToolBox {

  /**
   * アイテムを使用する.
   *
   * @param item 使用するアイテム
   */
  public void useItem(Item item);
}
