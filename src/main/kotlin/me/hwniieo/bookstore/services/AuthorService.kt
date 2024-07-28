package me.hwniieo.bookstore.services

import me.hwniieo.bookstore.domain.entities.AuthorEntity

interface AuthorService {

    fun save(authorEntity: AuthorEntity): AuthorEntity

}