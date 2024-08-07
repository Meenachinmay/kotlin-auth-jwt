package com.meenachinmay.kotlin_auth.repository

import com.meenachinmay.kotlin_auth.model.Role
import com.meenachinmay.kotlin_auth.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {
    private val users: MutableList<User> = mutableListOf(
        User (
            id = UUID.randomUUID(),
            email = "chinmayanand896@gmail.com",
            password = "password",
            role = Role.USER,
        ),
        User (
            id = UUID.randomUUID(),
            email = "chinmayanand896@icloud.com",
            password = "password",
            role = Role.ADMIN,
        ),
    )

    // CRUD operations for USER
    fun newUser(user : User): Boolean =
        users.add(user)

    fun findByEmail(email: String): User? =
        users.firstOrNull { it.email == email }

    fun findAll(): List<User> =
        users

    fun findByUUID(uuid: UUID): User? =
        users.firstOrNull { it.id == uuid }

    fun deleteByUUID(uuid: UUID): Boolean {
        val foundUser = findByUUID(uuid)

        return foundUser?.let {
            users.remove(it)
        } ?: false
    }

}
