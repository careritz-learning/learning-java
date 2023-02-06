package jp.co.careritztc.game.character.impl;

import jp.co.careritztc.game.character.GameCharacter;

/**
 * 人間クラス.
 */
public class Human extends GameCharacter {

  /**
   * コンストラクタ.
   *
   * @param name キャラクター名
   */
  public Human(String name) {
    super(name);
  }

  @Override
  public Integer attack() {
    // 時の運。ランダムな数値を返す。
    return Double.valueOf(Math.random() * 1000)
                 .intValue();
  }

  @Override
  public Boolean runaway(int speed) {
    // 人間に逃走は許されない。sppedに関わらず固定値falseを返す。
    return false;
  }
}
