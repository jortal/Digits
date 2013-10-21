package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents legal telephone types.
 * @author Jonathan Ortal
 *
 */

public class TelephoneTypes {
  
  private static String[] types = {"Home", "Work", "Mobile"};
  
  /**
   * Returns an initialized Map of telephone types (when no type is selected).
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }
  
  /**
   * Returns a Map of the selected telephone type.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes(String telType) {
    Map<String, Boolean> typeMap = TelephoneTypes.getTypes();
    if (isType(telType)) {
      typeMap.put(telType,  true);
    }
    return typeMap;
  }

  /**
   * Returns true if telType is valid type.
   * @param telType The telephone type.
   * @return True if valid, else false.
   */
  public static boolean isType(String telType) {
    return TelephoneTypes.getTypes().keySet().contains(telType);
  }
}
