package ru.netology.manager;

import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

public class CartAfisha {
    private static AfishaRepository repository;
    private int afishaLength = 4;

    public CartAfisha(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(Afisha item) {

        repository.save(item);
    }

    public Afisha[] getAll() {
        Afisha[] items = repository.findAll();
        int resultLength = Math.min(afishaLength, items.length);
        Afisha[] result = new Afisha[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
