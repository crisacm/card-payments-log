package com.github.crisacm.cardpaymentslog.nav

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavDestinations(
    private val baseRoute: String,
    private val navArgs: List<NavArgs> = emptyList()
) {
    data object Home : NavDestinations("home")
    data object Login : NavDestinations("login")

    val route = run {
        val argValue = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argValue)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }
}

enum class NavArgs(val key: String, val navType: NavType<*>) {
    Id("id", NavType.LongType)
}