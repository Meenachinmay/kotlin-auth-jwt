package com.meenachinmay.kotlin_auth.service

import com.meenachinmay.kotlin_auth.model.User
import com.meenachinmay.kotlin_auth.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        userRepository.findByEmail(username)
            ?.mapToUserDetails()
            ?: throw UsernameNotFoundException("User not found: $username")

    private fun User.mapToUserDetails(): UserDetails =
        org.springframework.security.core.userdetails.User
            .builder()
            .username(this.email)
            .password(this.password)
            .roles(this.role.name)
            .build()
}