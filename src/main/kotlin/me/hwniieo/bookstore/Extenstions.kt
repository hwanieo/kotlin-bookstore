package me.hwniieo.bookstore

import me.hwniieo.bookstore.domain.AuthorUpdateRequest
import me.hwniieo.bookstore.domain.dto.AuthorDto
import me.hwniieo.bookstore.domain.dto.AuthorUpdateRequestDto
import me.hwniieo.bookstore.domain.entities.AuthorEntity

fun AuthorEntity.toAuthorDto() = AuthorDto(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image
)

fun AuthorDto.toAuthorEntity() = AuthorEntity(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image
)

fun AuthorUpdateRequestDto.toAuthorUpdateRequest() = AuthorUpdateRequest(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image
)