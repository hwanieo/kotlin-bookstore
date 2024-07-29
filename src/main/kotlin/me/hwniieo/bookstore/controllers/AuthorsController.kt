package me.hwniieo.bookstore.controllers

import me.hwniieo.bookstore.domain.AuthorUpdateRequest
import me.hwniieo.bookstore.domain.dto.AuthorDto
import me.hwniieo.bookstore.domain.dto.AuthorUpdateRequestDto
import me.hwniieo.bookstore.services.AuthorService
import me.hwniieo.bookstore.toAuthorDto
import me.hwniieo.bookstore.toAuthorEntity
import me.hwniieo.bookstore.toAuthorUpdateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/v1/authors"])
class AuthorsController(private val authorService: AuthorService) {

    @PostMapping
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {
        try {
            val createdAuthor = authorService.create(authorDto.toAuthorEntity()).toAuthorDto()
            return ResponseEntity(createdAuthor, HttpStatus.CREATED)
        } catch (ex: IllegalArgumentException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun readManyAuthor(): List<AuthorDto> {
        return authorService.list().map { it.toAuthorDto() }
    }

    @GetMapping(path = ["/{id}"])
    fun readOneAuthor(@PathVariable("id") id: Long): ResponseEntity<AuthorDto> { // 이 경우는 200 또는 404를 반환할 수 있기 때문에 ResponseEntity
        val foundAuthor = authorService.get(id)?.toAuthorDto()
        return foundAuthor?.let {
            ResponseEntity(it, HttpStatus.OK)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping(path = ["/{id}"])
    fun fullUpdateAuthor(@PathVariable("id") id: Long, @RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {
        try {
            val updatedAuthor = authorService.fullUpdate(id, authorDto.toAuthorEntity())
            return ResponseEntity(updatedAuthor.toAuthorDto(), HttpStatus.OK)
        } catch (ex: IllegalStateException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PatchMapping(path = ["/{id}"])
    fun partialUpdateAuthor(
        @PathVariable("id") id: Long,
        @RequestBody authorUpdateRequestDto: AuthorUpdateRequestDto
    ): ResponseEntity<AuthorDto> {
        return try {
            val updatedAuthor = authorService.partialUpdate(id, authorUpdateRequestDto.toAuthorUpdateRequest())
            ResponseEntity(updatedAuthor.toAuthorDto(), HttpStatus.OK)
        } catch (ex: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

}