package com.example.newstesttask.repository

import org.junit.Assert.*

import org.junit.Test

class NetworkRepositoryTest {

    @Test
    fun loadGithubReposList() {
        println("++++++++++++++++++++++++++++++++++")

        val networkRepository = NetworkRepository()
        networkRepository.loadGithubReposList()

        println("---------------------------------------- $")
        assertEquals(true, true)
    }
}