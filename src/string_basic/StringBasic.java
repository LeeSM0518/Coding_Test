package string_basic;

public class StringBasic {

  public boolean solution(String s) {
    int length = s.length();
    try {
      Integer.parseInt(s);
      if (length == 4 || length == 6) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }

}
