package com.teamunknown.application.utils.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator


fun NavController.safeNavigate(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(resId, args, navOptions, navExtras)
    }
}

fun NavController.safeNavigate(
    navDestination: NavDirections,
    navOptions: NavOptions? = null
) {
    val action = currentDestination?.getAction(navDestination.actionId) ?: graph.getAction(navDestination.actionId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(navDestination, navOptions)
    }
}