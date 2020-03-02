package com.norbertneudert.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Media {
    private BigDecimal id;
    private String title;
    private String description;
    private LocalDate premier;
    private List<Review> reviews;
    private List<Actor> cast;
}
