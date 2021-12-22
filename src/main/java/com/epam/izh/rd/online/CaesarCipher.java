package com.epam.izh.rd.online;

import java.util.*;

/**
 * Класс реализует расшифровку "Шифра Цезаря"
 */
public class CaesarCipher {
    private final List<Character> alphabet = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');
    private String inputString;
    private char[] inputStringToChar;


    public CaesarCipher(String inputSring) {
        this.inputString = inputSring;
        inputStringToChar = inputSring.toCharArray();
    }


    /**
     * Сеттер для изменения входной строки
     * */
    public void setInputString(String inputString) {
        this.inputString = inputString;
        inputStringToChar = inputString.toCharArray();
    }


    /**
     * Метод перебирает все возможные сдвиги в поиске ключа к шифру
     */
    public void decryption() {
        for (int i = 1; i < alphabet.size(); i++) {
            getResultDecryption(i);
        }
    }


    /**
     * Метод выводит расшифровку по заданному сдвигу
     *
     * @param i  сдвиг, на сколько элементов нужно сдвинуть переданную строку
     */
    public void getResultDecryption(int i) {
        int index;
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : inputStringToChar) {
            if (c == ' ' || c == '.' || c == ',') {
                stringBuilder.append(c);
            } else {
                boolean isCharUpperCase;
                if (isCharUpperCase = Character.isUpperCase(c)) {
                    index = alphabet.indexOf(Character.toLowerCase(c));
                } else {
                    index = alphabet.indexOf(c);
                }
                index += +i;
                if (index > alphabet.size() - 1) {
                    index -= alphabet.size();
                }
                if (isCharUpperCase) {
                    stringBuilder.append(Character.toUpperCase(alphabet.get(index)));
                } else {
                    stringBuilder.append(alphabet.get(index));
                }
            }
        }
        System.out.println("Сдвиг: " + i);
        System.out.println(stringBuilder + "\n");
    }
}
