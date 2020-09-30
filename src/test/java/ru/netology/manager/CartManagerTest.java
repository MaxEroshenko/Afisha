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
    private Afisha third = new Afisha(3, 3, "url3", "name3", "genre3", 18, false);
    private Afisha forth = new Afisha(4, 4, "url4", "name4", "genre1", 6, true);

    @BeforeEach
    public void setUp() {
        cartAfisha.add(first);
        cartAfisha.add(second);
        cartAfisha.add(third);
    }

    @Test
    public void shouldAdd() {
        CartAfisha.add(forth);
        // настройка заглушки
        Afisha[] returned = new Afisha[]{first, second, third, forth};
        doReturn(returned).when(afishaRepository).findAll();

        Afisha[] expected = new Afisha[]{first, second, third, forth};
        Afisha[] actual = afishaRepository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {
        // настройка заглушки
        Afisha[] returned = new Afisha[]{first, second, third};
        doReturn(returned).when(afishaRepository).findAll();

        Afisha[] expected = new Afisha[]{third, second, first};
        Afisha[] actual = CartAfisha.getAll();
        assertArrayEquals(expected, actual);

    }
}
