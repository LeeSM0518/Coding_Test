package phone_list;

import java.util.HashSet;

public class PhoneList {

  static boolean answer = true;

  static class Phone {

    String number;

    Phone(String number) {
      this.number = number;
    }

    @Override
    public int hashCode() {
      return 1;
    }

    @Override
    public boolean equals(Object obj) {
      Phone str = (Phone) obj;
      if (number.indexOf(str.number) == 0
          || str.number.indexOf(number) == 0) answer = false;
      return false;
    }

  }

  public static boolean solution(String[] phoneBook) {
    int originLength = phoneBook.length;
    HashSet<Phone> phones = new HashSet<>();

    for (String phoneNumber : phoneBook) {
      phones.add(new Phone(phoneNumber));
      if (!answer) return false;
    }

    return originLength == phones.size();
  }

  public static void main(String[] args) {
    String[] phoneBook = {"119", "97674223", "1195524421"};

    System.out.println(solution(phoneBook));
  }

}