package me.hwniieo.bookstore.controllers

import me.hwniieo.bookstore.domain.dto.AuthorDto
import me.hwniieo.bookstore.services.AuthorService
import me.hwniieo.bookstore.toAuthorDto
import me.hwniieo.bookstore.toAuthorEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorsController(private val authorService: AuthorService) {

    @PostMapping(path = ["/v1/authors"])
    fun createAuthor(@RequestBody authorDto: AuthorDto): AuthorDto {
        return authorService.save(authorDto.toAuthorEntity()).toAuthorDto()
    }

}