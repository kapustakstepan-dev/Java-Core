package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Owner implements Serializable {
    private static final long  serializableVersionUID = 1234L;

    private String name;
    private String surname;
    private String email;
    private String dni;


}
