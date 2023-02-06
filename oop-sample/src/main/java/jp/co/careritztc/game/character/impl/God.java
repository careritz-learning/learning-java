package jp.co.careritztc.game.character.impl;

import jp.co.careritztc.game.character.GameCharacter;

/**
 * 神クラス.
 */
public class God extends GameCharacter {

  /**
   * コンストラクタ.
   *
   * @param name キャラクター名
   */
  public God(String name) {
    super(name);
  }

  @Override
  public Integer attack() {
    // 神の怒り。最大値を返す。
    return Integer.MAX_VALUE;
  }

  @Override
  public Boolean runaway(int speed) {
    // 神に失敗は無い。sppedに関わらず固定値trueを返す。
    return true;
  }
}
