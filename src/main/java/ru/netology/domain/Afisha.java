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
        private  boolean premiere;

}
