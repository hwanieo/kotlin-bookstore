package me.hwniieo.bookstore.services.impl

import jakarta.transaction.Transactional
import me.hwniieo.bookstore.controllers.AuthorsController
import me.hwniieo.bookstore.domain.AuthorUpdateRequest
import me.hwniieo.bookstore.domain.entities.AuthorEntity
import me.hwniieo.bookstore.repositories.AuthorRepository
import me.hwniieo.bookstore.services.AuthorService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService {

    override fun create(authorEntity: AuthorEntity): AuthorEntity {
        // 조건이 false일 때 IllegalArgsException 에러 발생
        require(null == authorEntity.id)
        return authorRepository.save(authorEntity)
    }

    override fun list(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

    override fun get(id: Long): AuthorEntity? {
        return authorRepository.findByIdOrNull(id)
    }

    @Transactional
    override fun fullUpdate(id: Long, authorEntity: AuthorEntity): AuthorEntity {
        // 조건이 false일 때 IllegalStateException 에러 발생
        check(authorRepository.existsById(id)) // 존재하지 않는 데이터 업데이트 방지

        // .copy() 데이터 클래스 기능, 객체의 복사본 생성
        // id=id 복사 과정에서 id 필드를 주어진 id 값으로 설정
        val normalisedAuthor = authorEntity.copy(id=id)
        return authorRepository.save(normalisedAuthor)
    }

    @Transactional
    override fun partialUpdate(id: Long, authorUpdateRequest: AuthorUpdateRequest): AuthorEntity {
        val existingAuthor = authorRepository.findByIdOrNull(id)
        checkNotNull(existingAuthor)

        val updatedAuthor = existingAuthor.copy(
            name = authorUpdateRequest.name ?: existingAuthor.name,
            age = authorUpdateRequest.age ?: existingAuthor.age,
            description = authorUpdateRequest.description ?: existingAuthor.description,
            image = authorUpdateRequest.image ?: existingAuthor.image,
        )

        return authorRepository.save(updatedAuthor)
    }

}