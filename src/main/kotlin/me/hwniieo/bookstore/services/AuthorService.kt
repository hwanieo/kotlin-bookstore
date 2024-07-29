package me.hwniieo.bookstore.services

import me.hwniieo.bookstore.domain.AuthorUpdateRequest
import me.hwniieo.bookstore.domain.entities.AuthorEntity

interface AuthorService {

    fun create(authorEntity: AuthorEntity): AuthorEntity

    fun list(): List<AuthorEntity>

    fun get(id: Long): AuthorEntity?

    fun fullUpdate(id: Long, authorEntity: AuthorEntity): AuthorEntity

    fun partialUpdate(id: Long, authorUpdateRequest: AuthorUpdateRequest): AuthorEntity

}