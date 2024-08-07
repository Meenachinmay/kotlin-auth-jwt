package com.meenachinmay.kotlin_auth.service

import com.meenachinmay.kotlin_auth.model.User
import com.meenachinmay.kotlin_auth.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (private val userRepository: UserRepository) {
    fun create(user: User): User? {
       val foundUser = userRepository.findByEmail(user.email)

        return if (foundUser == null) {
            userRepository.newUser(user)
            user
        } else null
    }

    fun findByUUID(uuid: UUID): User? {
        return userRepository.findByUUID(uuid)
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun deleteByUUID(uuid: UUID): Boolean {
        return userRepository.deleteByUUID(uuid)
    }
}