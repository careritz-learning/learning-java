package jp.co.careritztc.day3.exercise1.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.careritztc.day3.exercise1.pojo.Staff;
import jp.co.careritztc.day3.exercise1.pojo.Staff.Gender;

/**
 * ExampleTypeMapクラス.
 */
public class ExampleTypeMap {

  private static final Map<String, Staff> STAFFS;

  static {
    Map<String, Staff> map = new HashMap<>();
    map.put("Sato Taro", new Staff("Taro", "Sato", Gender.MALE, 50000));
    map.put("Ito Hana", new Staff("Hana", "Ito", Gender.FEMALE, 60000));
    map.put("Suzuki Ken", new Staff("Ken", "Suzuki", Gender.MALE, 55000));
    map.put("Yamada Jiro", new Staff("Jiro", "Yamada", Gender.MALE, 60000));
    map.put("Watanabe Mai", new Staff("Mai", "Watanabe", Gender.FEMALE, 100000));

    STAFFS = Collections.unmodifiableMap(map);
  }

  private ExampleTypeMap() {
  }

  public static Map<String, Staff> getSampleData() {
    return STAFFS;
  }
}
