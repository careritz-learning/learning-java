package jp.co.careritztc.game.character.impl;

/**
 * ゲームマスタークラス.
 */
public class GameMaster extends God {

  /**
   * コンストラクタ.
   *
   * @param name キャラクター名
   */
  public GameMaster(String name) {
    super(name);
  }

  public Integer superAttack() {
    return attack();
  }

  @Override
  public Boolean runaway(int speed) {
    // 神に失敗は無い。sppedに関わらず固定値trueを返す。
    return true;
  }
}
