package com.gitlab.kordlib.core

import com.gitlab.kordlib.gateway.Intents
import io.ktor.client.HttpClient

class ClientResources(
        val token: String,
        val shardCount: Int,
        val httpClient: HttpClient,
        val intents: Intents?
)