package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libros {

    private long id;
    private long year;
    private String title;
    private String handle;
    private String publisher;
    private String isbn;
    private long pages;
    private String[] notes;
}
