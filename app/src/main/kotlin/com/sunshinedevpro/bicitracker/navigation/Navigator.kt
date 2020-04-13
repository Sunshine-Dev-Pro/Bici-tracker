package com.sunshinedevpro.bicitracker.navigation

interface Navigator {
    fun showMainScreen()
    fun showMapsScreen()
    fun showChatsScreen()
    fun showChatRoomScreen(id: Int)
    fun showSettingsScreen()
}
