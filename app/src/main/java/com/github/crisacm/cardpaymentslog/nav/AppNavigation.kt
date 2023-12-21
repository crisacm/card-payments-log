package com.github.crisacm.cardpaymentslog.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavDestinations.Home.route
    ) {
        composable(NavDestinations.Home) {

        }
        composable(NavDestinations.Login) {
            // Testing passing arguments
            val id = it.findArg<Long>(NavArgs.Id.key)?.toLong()
        }
    }
}

private fun NavGraphBuilder.composable(
    navDestinations: NavDestinations,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navDestinations.route,
        arguments = navDestinations.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(key: String): T? {
    val value = arguments?.get(key)
    requireNotNull(value)
    return value as T
}
