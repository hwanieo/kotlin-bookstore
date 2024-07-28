package me.hwniieo.bookstore.repositories

import me.hwniieo.bookstore.domain.entities.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface BookRepository : JpaRepository<BookEntity, Long> {
}