package jp.co.careritztc.day2.answer2.data;

import java.time.LocalDate;
import java.util.Collections;
// import java.util.HashMap;  // 1行目修正点
import java.util.LinkedHashMap;
import java.util.Map;
import jp.co.careritztc.day2.answer2.pojo.Staff;
import jp.co.careritztc.day2.answer2.pojo.Staff.Gender;

public class ExampleTypeMap {

  private static final Map<String, Staff> staffs;
  static {
    // Map<String, Staff> map = new HashMap<>(); // 2行目修正点
    Map<String, Staff> map = new LinkedHashMap<>();
    map.put("Sato Taro", new Staff("Taro", "Sato", Gender.MALE, 50000, LocalDate.of(1995, 2, 14)));
    map.put("Ito Hana", new Staff("Hana", "Ito", Gender.FEMALE, 60000, LocalDate.of(1990, 3, 3)));
    map.put("Suzuki Ken", new Staff("Ken", "Suzuki", Gender.MALE, 55000, LocalDate.of(1995, 2, 14)));
    map.put("Yamada Jiro", new Staff("Jiro", "Yamada", Gender.MALE, 60000, LocalDate.of(1978, 8, 24)));
    map.put("Watanabe Mai", new Staff("Mai", "Watanabe", Gender.FEMALE, 100000, LocalDate.of(1973, 11, 17)));

    staffs = Collections.unmodifiableMap(map);
  }

  private ExampleTypeMap() {
  }

  public static Map<String, Staff> getSampleData() {
    return staffs;
  }
}
