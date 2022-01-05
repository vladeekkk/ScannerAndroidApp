package com.hedgehog.scanner.domain.usecases

import com.hedgehog.scanner.domain.AppModel
import com.hedgehog.scanner.domain.InfoRepository

class GetAppsImageAndNameUseCase(
    private val repository: InfoRepository,
//    private val mapper: Any,
    ) {

    fun execute(): List<AppModel> {
        return repository.fetchAppsImageName().map {
            AppModel(
                it.drawable,
                it.appName,
                it.packageName,
            )
        }
    }
}