package ru.otus.homework8.repository;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.homework8.domain.Author;
import ru.otus.homework8.domain.Book;
import ru.otus.homework8.domain.Comment;
import ru.otus.homework8.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@DataMongoTest
@DisplayName("Репозиторий для работы с жанрами должен")
class GenreRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("добавлять жанр")
    @Test
    void shouldCorrectInsert() {
        val expectedGenre = new Genre("expected_genre");
        genreRepository.save(expectedGenre);
        val actualGenre = genreRepository.findById(expectedGenre.getId());
        assertThat(actualGenre).isPresent().get().usingRecursiveComparison().isEqualTo(expectedGenre);
    }

    @DisplayName("обновлять жанр")
    @Test
    void shouldCorrectUpdate() {
        val expectedGenre = new Genre("id_genre1", "expected_genre1");
        val expectedAuthor = new Author("id_author1", "author1");
        val expectedBook = new Book("id_book1", "book1", expectedAuthor, expectedGenre);
        val expectedComment1 = new Comment("id_comment1", "comment1", expectedBook);
        val expectedComment2 = new Comment("id_comment2", "comment2", expectedBook);

        genreRepository.saveCustom(expectedGenre);

        val actualAuthor = authorRepository.findById(expectedAuthor.getId());
        val actualGenre = genreRepository.findById(expectedGenre.getId());
        val actualBook = bookRepository.findById(expectedBook.getId());
        val actualComment1 = commentRepository.findById(expectedComment1.getId());
        val actualComment2 = commentRepository.findById(expectedComment2.getId());
        assertAll(
                () -> assertThat(actualAuthor).isPresent().get().usingRecursiveComparison().isEqualTo(expectedAuthor),
                () -> assertThat(actualGenre).isPresent().get().usingRecursiveComparison().isEqualTo(expectedGenre),
                () -> assertThat(actualBook).isPresent().get().usingRecursiveComparison().isEqualTo(expectedBook),
                () -> assertThat(actualComment1).isPresent().get().usingRecursiveComparison().isEqualTo(expectedComment1),
                () -> assertThat(actualComment2).isPresent().get().usingRecursiveComparison().isEqualTo(expectedComment2)
        );
    }

    @DisplayName("получать жанр по id")
    @Test
    void shouldCorrectFindById() {
        val expectedGenre = new Genre("id_genre2", "genre2");
        val actualGenre = genreRepository.findById(expectedGenre.getId());
        assertThat(actualGenre).isPresent().get().usingRecursiveComparison().isEqualTo(expectedGenre);
    }

    @DisplayName("должен загружать список всех жанров")
    @Test
    void shouldCorrectFindAll() {
        val genres = genreRepository.findAll();
        assertThat(genres).isNotNull().hasSizeGreaterThan(0)
                .allMatch(g -> !g.getName().equals(""));
    }

    @DisplayName("удалять жанр по id")
    @Test
    void shouldCorrectDeleteById() {

        val deleteGenreId = "id_genre3";
        genreRepository.deleteByIdCustom(deleteGenreId);

        val expectedGenre = genreRepository.findById(deleteGenreId);
        val expectedBooks = bookRepository.findAllByGenreId(deleteGenreId);
        val expectedComments = commentRepository.findAllByBookGenreId(deleteGenreId);

        assertAll(
                () -> assertThat(expectedGenre).isEmpty(),
                () -> assertThat(expectedBooks).isEmpty(),
                () -> assertThat(expectedComments).isEmpty()
        );
    }
}