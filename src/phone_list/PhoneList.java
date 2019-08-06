package phone_list;

import java.util.HashSet;

public class PhoneList {

  public static boolean solution(String[] phoneBook) {
    int originLength = phoneBook.length;
    HashSet<Phone> phones = new HashSet<>();

    for (String phoneNumber : phoneBook) {
      phones.add(new Phone(phoneNumber));
    }

    return originLength == phones.size();
  }

  public static void main(String[] args) {
    String[] phoneBook = {"119", "97674223", "1195524421"};

    System.out.println(solution(phoneBook));
  }

}

class Phone {

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
    return (number.indexOf(str.number) == 0
        || str.number.indexOf(number) == 0);
  }

}