package ru.netology.manager;

import ru.netology.domain.Afisha;
import ru.netology.repository.CartRepository;

public class CartAfisha {
    private CartRepository repository;

    public CartAfisha(CartRepository repository) {
        this.repository = repository;
    }

    public void add(Afisha item) {
        repository.save(item);
    }

    public Afisha[] getAll() {
        Afisha[] items = repository.findAll();
        Afisha[] result = new Afisha[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
