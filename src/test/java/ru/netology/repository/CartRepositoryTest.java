package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartRepositoryTest {
    private AfishaRepository afishaRepository = new AfishaRepository();

    private Afisha first = new Afisha(1, 1, "url1", "name1", "genre1", 6, true);
    private Afisha second = new Afisha(2, 2, "url2", "name2", "genre2", 12, false);
    private Afisha third = new Afisha(3, 3, "url3", "name3", "genre3", 18, false);

    @BeforeEach
    public void setUpAPoster() {
        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
    }

    @Test
    public void addMovie() {
        Afisha[] actual = afishaRepository.findAll();
        Afisha[] expected = new Afisha[]{first, second, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void needToDelete() {
        int idToRemove = 2;
        afishaRepository.removeById(idToRemove);
        Afisha[] actual = afishaRepository.findAll();
        Afisha[] expected = new Afisha[]{first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        int findId = 2;
        Afisha actual = afishaRepository.findById(findId);
        Afisha expected = second;

        assertEquals(expected, actual);
    }

    @Test
    public void needToSearchByIdIfItDoesnExist() {
        int findId = 4;
        Afisha actual = afishaRepository.findById(findId);

        assertEquals(null, actual);
    }

    @Test
    public void deleteEverything() {
        afishaRepository.removeAll();
        Afisha[] actual = afishaRepository.removeAll();
        Afisha[] expected = new Afisha[0];

        assertArrayEquals(expected, actual);
    }

}
