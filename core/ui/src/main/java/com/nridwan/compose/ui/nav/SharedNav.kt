package com.nridwan.compose.ui.nav

object SharedNav {
    const val ROOT = "root"
    const val AUTH = "auth"
    const val SPLASH = "splash"
    const val HOME = "home"
    private val all = listOf(
        AUTH,
        SPLASH,
        HOME
    )
    fun allExcept(route: String) = all.filter { it != route }
}