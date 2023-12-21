import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    @Test
    public void thereNoMovies() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void equalLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Номер один");
        manager.addMovie("Вперед");
        String[] expected = {"Бладшот", "Отель Белград", "Джентельмены", "Номер один", "Вперед"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lessThenLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moreThenLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Номер один");
        manager.addMovie("Вперед");
        manager.addMovie("Хроники Риддика");
        String[] expected = {"Бладшот", "Отель Белград", "Джентельмены", "Номер один", "Вперед", "Хроники Риддика"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void moreLastUnderLimit() {
        MovieManager manager = new MovieManager(7);
        manager.addMovie("Бладшот");
        String[] expected = {"Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moreLastMoreLimit() {
        MovieManager manager = new MovieManager(1);
        manager.addMovie("Бладшот");
        manager.addMovie("Проклятье");
        String[] expected = {"Проклятье"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void equalLastLimit() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Бладшот");
        manager.addMovie("Проклятье");
        String[] expected = {"Проклятье", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

}
