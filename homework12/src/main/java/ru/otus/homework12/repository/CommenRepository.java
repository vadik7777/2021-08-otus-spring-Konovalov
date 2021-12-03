package ru.otus.homework12.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework12.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommenRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(attributePaths = "book")
    Optional<Comment> findById(Long id);

    List<Comment> findCommentByBookId(long bookId);
}