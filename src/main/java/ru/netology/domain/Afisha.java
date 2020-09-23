package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Afisha {
        private int id;
        private int movieId;
        private String imageUrl;
        private String name;
        private String genre;
        private int ageLimit;
        private boolean premiere;

        public Afisha(int i, int i1, String url1, String name1, String genre1, int i2) {

        }
}
