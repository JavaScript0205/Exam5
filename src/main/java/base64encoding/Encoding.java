package base64encoding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Encoding {
    public static void main(String[] args)  {
        try {
            FileInputStream in = new FileInputStream("Konsta.mp3"); // endcode
            FileOutputStream outputStream = new FileOutputStream("Konsta.txt"); // endcode

//            FileInputStream in = new FileInputStream("Konsta.txt"); // decode
//            FileOutputStream outputStream = new FileOutputStream("Dada.mp3"); // decode

            byte[] bytes = in.readAllBytes();

            outputStream.write(encoding(bytes));
//            outputStream.write(decoding(bytes)); // decode

            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] encoding(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();

        return encoder.encode(bytes);
    }

    private static byte[] decoding(byte[] bytes) {
        Base64.Decoder decoder = Base64.getDecoder();

        return decoder.decode(bytes);
    }
}
