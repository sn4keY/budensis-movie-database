package com.norbertneudert.bmdb.domain;

import java.time.LocalDate;
import java.util.List;

public class Actor {
    private String name;
    private LocalDate born;
    private Sex sex;
    private String biography;
    private List<Media> filmography;
}
