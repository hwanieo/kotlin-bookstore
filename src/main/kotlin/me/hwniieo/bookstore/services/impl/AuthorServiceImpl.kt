package me.hwniieo.bookstore.services.impl

import me.hwniieo.bookstore.domain.entities.AuthorEntity
import me.hwniieo.bookstore.repositories.AuthorRepository
import me.hwniieo.bookstore.services.AuthorService
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {

    override fun save(authorEntity: AuthorEntity): AuthorEntity {
        return authorRepository.save(authorEntity)
    }

}