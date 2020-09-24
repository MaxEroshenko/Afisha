package ru.netology.manager;


import org.junit.jupiter.api.Test;

import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


public class CartManagerTest {


        private CartAfisha manager = new CartAfisha();
    private Afisha first = new Afisha(1, 1, "url1", "name1", "genre1", 6, true);
        private Afisha second = new Afisha(2, 2, "url2", "name2", "genre2", 12, false);
        private Afisha third = new Afisha(3, 3, "url3", "name3", "genre3", 16, false);
        private Afisha forth = new Afisha(4, 4, "url4", "name4", "genre1", 6, true);
        private Afisha fifth = new Afisha(5, 5, "url5", "name5", "genre2", 12, false);
        private Afisha sixth = new Afisha(6, 6, "url6", "name6", "genre3", 18, false);
        private Afisha seventh = new Afisha(7, 7, "url7", "name7", "genre1", 6, true);
        private Afisha eighth = new Afisha(8, 8, "url8", "name8", "genre2", 12, false);
        private Afisha ninth = new Afisha(9, 9, "url9", "name9", "genre3", 15, false);
        private Afisha tenth = new Afisha(10, 10, "url10", "name10", "genre1", 6, true);
        private Afisha eleventh = new Afisha(11, 11, "url11", "name11", "genre2", 12, false);
        private Afisha twelfth = new Afisha(12, 12, "url12", "name12", "genre3", 17, false);

        @Test
        public void giveTenOutOfTwelve() {
            manager.add(first);
            manager.add(second);
            manager.add(third);
            manager.add(forth);
            manager.add(fifth);
            manager.add(sixth);
            manager.add(seventh);
            manager.add(eighth);
            manager.add(ninth);
            manager.add(tenth);
            manager.add(eleventh);
            manager.add(twelfth);

            Afisha[] actual = manager.getAll();
            Afisha[] expected = new Afisha[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void giveTenOutOfTen() {
            manager.add(first);
            manager.add(second);
            manager.add(third);
            manager.add(forth);
            manager.add(fifth);
            manager.add(sixth);
            manager.add(seventh);
            manager.add(eighth);
            manager.add(ninth);
            manager.add(tenth);

            Afisha[] actual = manager.getAll();
            Afisha[] expected = new Afisha[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void releaseFiveFilms() {
            CartAfisha movieManager = new CartAfisha(5);
            movieManager.add(first);
            movieManager.add(second);
            movieManager.add(third);
            movieManager.add(forth);
            movieManager.add(fifth);

            Afisha[] actual = movieManager.getAll();
            Afisha[] expected = new Afisha[]{fifth, forth, third, second, first};

            assertArrayEquals(expected, actual);
        }
}
