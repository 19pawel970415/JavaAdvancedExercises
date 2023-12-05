package classesInterfaces.ex2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie {

    private String title;
    private String director;
    private Integer releaseYear;
    private String genre;
    private String studio;

    static class MovieCreator {

        private String title;
        private String director;
        private Integer releaseYear;
        private String genre;
        private String studio;

        public MovieCreator setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieCreator setDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieCreator setReleaseYear(Integer releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public MovieCreator setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieCreator setStudio(String studio) {
            this.studio = studio;
            return this;
        }

        public Movie createMovie() {
            Movie movie = new Movie(title, director, releaseYear, genre, studio);
            return movie;
        }
    }
}
