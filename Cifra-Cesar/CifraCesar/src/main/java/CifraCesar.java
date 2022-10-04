import java.util.HashMap;
import java.util.Map;

public class CifraCesar {

    public String encipher(String plaintext){
        String ciphertext = "";

        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "a");
        mapa.put(2, "b");
        mapa.put(3, "c");
        mapa.put(4, "d");
        mapa.put(5, "e");
        mapa.put(6, "f");
        mapa.put(7, "g");
        mapa.put(8, "h");
        mapa.put(9, "i");
        mapa.put(10, "j");
        mapa.put(11, "k");
        mapa.put(12, "l");
        mapa.put(13, "m");
        mapa.put(14, "n");
        mapa.put(15, "o");
        mapa.put(16, "p");
        mapa.put(17, "q");
        mapa.put(18, "r");
        mapa.put(19, "s");
        mapa.put(20, "t");
        mapa.put(21, "u");
        mapa.put(22, "v");
        mapa.put(23, "w");
        mapa.put(24, "x");
        mapa.put(25, "y");
        mapa.put(26, "z");

        for(int i = 0; i < plaintext.length(); i++){
            String ch = "";
            for(int j = 1; j <= 26; j++){
                if(mapa.get(j).equals(String.valueOf(plaintext.charAt(i)))){
                    ch = mapa.get((j+3)%26);
                    break;
                }
            }
            ciphertext = ciphertext + ch;
        }
        return ciphertext;
    }
}