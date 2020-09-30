package ru.netology.repository;

import ru.netology.domain.Afisha;

public class AfishaRepository {

    private Afisha[] items = new Afisha[0];

    public Afisha[] findAll() {
        return items;
    }

    public void save(Afisha item) {
        int length = items.length + 1;
        Afisha[] tmp = new Afisha[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
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

    public Afisha findById(int id) {
        for (Afisha item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Afisha[] removeAll() {
        Afisha[] items = new Afisha[0];

        return items;
    }
}
