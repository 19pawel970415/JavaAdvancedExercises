package OOP.movies;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Movie implements AudienceReaction {
    private String name;
    private MovieType type;
    private LocalDate releaseDate;
    private String authorName;

    @Override
    public void react() {
        if (type == MovieType.ACTION) {
            System.out.println("Wooooow");
        } else if (type == MovieType.COMEDY) {
            System.out.println("Hahahahahaha");
        } else if (type == MovieType.DRAMA) {
            System.out.println("Sob sob sob");
        } else {
            System.out.println("AAAAAAA!!!!!!");
        }
    }
}
