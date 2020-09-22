package ru.netology.repository;

import ru.netology.domain.Afisha;

public class CartRepository {
    private Afisha[] items = new Afisha[0];

    public void save(Afisha item) {
        int length = items.length + 1;
        Afisha[] tmp = new Afisha[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Afisha[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Afisha[] tmp = new Afisha[length];
        int index = 0;
        for (Afisha item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
