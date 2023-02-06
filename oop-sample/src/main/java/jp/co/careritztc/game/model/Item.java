package jp.co.careritztc.game.model;

/**
 * アイテムクラス.
 */
public class Item {
  // アイテム名
  private String name;

  /**
   * アイテム名を返す.
   *
   * @return アイテム名
   */
  public String getName() {
    return name;
  }

  /**
   * アイテム名を設定する.
   *
   * @param name アイテム名
   */
  public void setName(String name) {
    this.name = name;
  }
}
