package me.hwniieo.bookstore

import me.hwniieo.bookstore.domain.dto.AuthorDto
import me.hwniieo.bookstore.domain.entities.AuthorEntity

//fun testAuthorDtoA(id: Long? = null): AuthorDto {
//    return AuthorDto(
//        id = id,
//        name = "John Doe",
//        age = 30,
//        description = "Some Description",
//        image = "john-doe.jpeg"
//    )
//}

fun testAuthorDtoA(id: Long? = null) = AuthorDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg"
)

fun testAuthorEntityA(id: Long? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg"
)

fun testAuthorEntityB(id: Long? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg"
)

fun testAuthorUpdateRequestDtoA(id: Long? = null) = AuthorEntity(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg"
)