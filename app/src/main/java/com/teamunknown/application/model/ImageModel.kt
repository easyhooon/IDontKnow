package com.teamunknown.application.model

import kotlin.random.Random

class ImageModel {
    companion object {
        fun randomTitleImage(): String {
            val titleImages = listOf(
                "https://images.unsplash.com/photo-1648737155328-0c0012cf2f20?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MXwxfHNlYXJjaHwxfHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1488646953014-85cb44e25828?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwyfHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1500835556837-99ac94a94552?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwzfHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHw0fHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1530521954074-e64f6810b32d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHw1fHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1476514525535-07fb3b4ae5f1?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHw2fHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1507608616759-54f48f0af0ee?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHw3fHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1648737966316-864c713a8356?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MXwxfHNlYXJjaHw4fHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1504150558240-0b4fd8946624?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHw5fHx0cmF2ZWx8ZW58MHx8fHwxNjU0MzQzOTU1&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1552733407-5d5c46c3bb3b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxMHx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1527631746610-bca00a040d60?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxMXx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1488085061387-422e29b40080?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxMnx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1503220317375-aaad61436b1b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxM3x8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1523906834658-6e24ef2386f9?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxNHx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1648737966174-c5ef7b893fcd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MXwxfHNlYXJjaHwxNXx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1568849676085-51415703900f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxNnx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1501785888041-af3ef285b470?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxN3x8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1528543606781-2f6e6857f318?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxOHx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwxOXx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080",
                "https://images.unsplash.com/photo-1539635278303-d4002c07eae3?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxNTkxNTV8MHwxfHNlYXJjaHwyMHx8dHJhdmVsfGVufDB8fHx8MTY1NDM0Mzk1NQ&ixlib=rb-1.2.1&q=80&w=1080"
            )

            return titleImages[Random.nextInt(titleImages.size)]
        }
    }
}