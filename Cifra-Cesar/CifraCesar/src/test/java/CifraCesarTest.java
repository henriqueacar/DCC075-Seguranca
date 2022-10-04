import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CifraCesarTest {

    @Test
    public void deveVefiricarCifra(){
        String plaintext = "este e um exemplo de cifra de ceasar utilizando apenas letras";
        String ciphertext = "hvwhhxphahpsorghfliudghfhdvduxwlolcdqgrdshqdvohwudv";
        CifraCesar cifra = new CifraCesar();
        assertEquals(ciphertext, cifra.encipher(plaintext));
    }

}