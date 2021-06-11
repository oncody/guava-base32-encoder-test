import com.google.common.io.BaseEncoding;

import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        int BITS_PER_BYTE = 8;
        int BITS_PER_BASE_32_CHAR = 5;

        SecureRandom randomDataGenerator = new SecureRandom();
        BaseEncoding base32Encoder = BaseEncoding.base32();

        for(int charCount = 1; charCount <= 20; charCount++) {
            int byteCount = (int) Math.ceil((1.0 * charCount * BITS_PER_BASE_32_CHAR) / BITS_PER_BYTE);
            int bitCount = byteCount * BITS_PER_BYTE;

            byte[] randomBytes = new byte[byteCount];
            randomDataGenerator.nextBytes(randomBytes);
            String randomString = base32Encoder.encode(randomBytes);
            String trimmedRandomString = randomString.substring(0, charCount);
//            String paddedTrimmedRandomString = randomString.substring(0, charCount) + "E";
            System.out.println(String.format("Chars: (%s) Bytes: (%s) Bits: (%s) String: (%s) Trimmed: (%s) ", charCount, byteCount, bitCount, randomString, trimmedRandomString));
//            byte[] trimmedStringBytes = base32Encoder.decode(paddedTrimmedRandomString);
        }
    }
}
