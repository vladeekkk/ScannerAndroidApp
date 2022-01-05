package com.hedgehog.scanner.domain

interface InfoRepository {

    fun fetchAppsImageName(): List<AppModel>

    fun fetchAppInfo(): Any
}