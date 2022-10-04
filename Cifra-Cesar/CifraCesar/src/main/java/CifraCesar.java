import java.util.*;

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
        analiseFrequencia(ciphertext);
        return ciphertext;
    }

    /*
        Método de Análise de Frequência
        A ideia é criar três ArrayList (letras, frequencia e percentual) e fazer com que cada index
        dos arrays representem a mesma coisa.
        Ex: letras[0]="a"
            frequencia[0] representa quantas vezes "a" aparece na cifra
            percentual[0] representa qual a porcentagem de "a"

        A variável mapaOrdenado é uma TreeMap, ordenada alfabeticamente, que guarda as informações
        de todos os arrays para visualizar os dados.
     */
    public void analiseFrequencia(String ciphertext){
        ArrayList<String> letras = new ArrayList<>();
        ArrayList<Integer> frequencia = new ArrayList<>();
        ArrayList<Float> percentual = new ArrayList<>();
        Map<String, ArrayList<Float>> mapaOrdenado = new TreeMap<>();
        Integer totalLetras = ciphertext.length();

        /*
            FOR para criar um ArrayList contendo letras únicas da Cifra
         */
        for (int i = 0; i < ciphertext.length(); i++){
            if(!letras.contains(String.valueOf(ciphertext.charAt(i)))){
                letras.add(String.valueOf(ciphertext.charAt(i)));
            }
        }

        /*
            FOR para inicializar os ArrayLists de frequencia e percentual
            com o mesmo tamanho do ArrayList de letras únicas
         */
        for(int i = 0; i < letras.size(); i++){
            frequencia.add(0);
            percentual.add((float)0);
        }

        /*
            FOR para incrementar o array de frequências para cada aparição
            da respectiva letra. Este incremento é feito no index de mesmo número em que a letra
            aparece no array de letras
         */
        for(int i = 0; i < ciphertext.length(); i++){
            frequencia.set(
                    letras.indexOf(String.valueOf(ciphertext.charAt(i))),
                    (frequencia.get(letras.indexOf(String.valueOf(ciphertext.charAt(i)))))+1);
        }

        /*
            FOR para juntar todos os arrays em um TreeMap ordenado alfabeticamente
            Resultado-> letra : quantidade de aparições na cifra : percentual
         */
        for(int i = 0; i < frequencia.size(); i++){
            percentual.set(i,((float) frequencia.get(i)/totalLetras)*100);
            mapaOrdenado.put(letras.get(i), new ArrayList<>() );
            mapaOrdenado.get(letras.get(i)).add((float)frequencia.get(i));
            mapaOrdenado.get(letras.get(i)).add(percentual.get(i));

        }

        System.out.println(mapaOrdenado);
    }
}
