package ru.netology.manager;

import ru.netology.domain.Afisha;

public class CartAfisha {
    private Afisha[] items = new Afisha[0];

    public CartAfisha(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public CartAfisha() {
    }

    private int afishaLength = 10;


    public void add(Afisha item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Afisha[] tmp = new Afisha[length];
        // копируем поэлементно
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Afisha[] getAll() {
        int resultLength = Math.min(afishaLength, items.length);
        Afisha[] result = new Afisha[resultLength];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
