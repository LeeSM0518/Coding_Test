package phone_number_hide;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneNumberHide {

  public String solution(String phone_number) {
    return phone_number.replace(phone_number.substring(0, phone_number.length() - 4),
        Stream.of(phone_number.split(""))
        .map(s -> "*")
        .limit(phone_number.length() - 4)
        .collect(Collectors.joining()));
  }

  public static void main(String[] args) {
    String phoneNumber = "01033334444";
    PhoneNumberHide hide = new PhoneNumberHide();
    System.out.println(hide.solution(phoneNumber));
  }

}
