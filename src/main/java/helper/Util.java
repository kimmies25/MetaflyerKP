package helper;

import java.util.Random;

public class Util {
    public String generateUsername() {
            String baseUsername = "username";
            Random random = new Random();
            int randomNumber = random.nextInt(10000);
            String formattedNumber = String.format("%04d", randomNumber);
            String username = baseUsername + formattedNumber;
            return username;
        }

        public static String generatePhoneNumber() {
            Random random = new Random();
            int part1 = random.nextInt(900) + 100;
            int part2 = random.nextInt(10000);
            String formattedPart2 = String.format("%04d", part2);
            int part3 = random.nextInt(10000);
            String formattedPart3 = String.format("%04d", part3);
            String phoneNumber = part1 + "-" + formattedPart2 + "-" + formattedPart3;
            return phoneNumber;


    }


}
