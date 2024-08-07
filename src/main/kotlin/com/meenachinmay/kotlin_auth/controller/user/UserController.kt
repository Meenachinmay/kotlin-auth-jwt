package com.meenachinmay.kotlin_auth.controller.user

import com.meenachinmay.kotlin_auth.model.Role
import com.meenachinmay.kotlin_auth.model.User
import com.meenachinmay.kotlin_auth.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @PostMapping
    fun createUser(@RequestBody user: UserRequest): UserResponse =
        (userService.create(
            user = user.toModel()
        )
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create user"))

    @GetMapping()
    fun getAllUsers(): List<UserResponse> =
        userService.findAll().map { it.toResponse() }

    private fun UserRequest.toModel(): User =
        User(
            id = UUID.randomUUID(),
            email = this.email,
            password = this.password,
            role = Role.USER,
            )

    private fun User.toResponse(): UserResponse =
        UserResponse(
            uuid = this.id,
            email = this.email,
        )
}