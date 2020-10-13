package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CartManagerTest {
    @Mock
    private AfishaRepository afishaRepository;
    @InjectMocks
    private CartAfisha cartAfisha;
    private Afisha first = new Afisha(1, 1, "url1", "name1", "genre1", 6, true);
    private Afisha second = new Afisha(2, 2, "url2", "name2", "genre2", 12, false);
    private Afisha third = new Afisha(3, 3, "url3", "name3", "genre3", 6, true);
    private Afisha fourth = new Afisha(4, 4, "url4", "name4", "genre4", 6, true);

    @BeforeEach
    public void setUp() {
        cartAfisha.add(first);
        cartAfisha.add(second);
        cartAfisha.add(third);
        cartAfisha.add(fourth);
    }

    @Test
    void shouldAdd() {


        Afisha[] returned = new Afisha[]{first, second, third, fourth};
        doReturn(returned).when(afishaRepository).findAll();
        doNothing().when(afishaRepository).save(fourth);


        cartAfisha.add(fourth);
        Afisha[] actual = cartAfisha.getAll();
        Afisha[] expected = new Afisha[]{fourth, third, second, first};

        assertArrayEquals(expected, actual);

    }

    @Test
    void doesNotAddFilms() {

        Afisha[] returned = new Afisha[]{};
        doReturn(returned).when(afishaRepository).findAll();

        cartAfisha.add(third);
        Afisha[] actual = cartAfisha.getAll();
        Afisha[] expected = new Afisha[]{};

        assertArrayEquals(expected, actual);


    }

    @Test
    void moreThanThreeShouldBeAdded() {

        Afisha[] returned = new Afisha[]{first, second, third};
        doReturn(returned).when(afishaRepository).findAll();
        doNothing().when(afishaRepository).save(fourth);

        cartAfisha.add(fourth);
        Afisha[] actual = cartAfisha.getAll();
        Afisha[] expected = new Afisha[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}
