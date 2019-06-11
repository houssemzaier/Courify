package com.bravedroid.sugarplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bravedroid.sugar.categories.PrimaryCategoryCarousel
import com.bravedroid.sugar.categories.PrimaryCategoryItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val primaryCategoryCarousel = findViewById<PrimaryCategoryCarousel>(R.id.carousel)
        primaryCategoryCarousel.enableSeeMoreButton()
        primaryCategoryCarousel.setCategories(primaryCategoryItems) {
            Log.d("DEBG", "see more !")
        }
    }

    private val primaryCategoryItems = listOf(
        PrimaryCategoryItem(
            "id 1",
            "Math",
            "https://cdn-images-1.medium.com/max/2560/1*XhGXauk7Q3fTdo5Yb5BHng.jpeg"
        ) {
            Log.d("DEBG", "id 1 clicked")
        },
        PrimaryCategoryItem(
            "id 2",
            "Algebra",
            "https://cdn-images-1.medium.com/max/800/1*jP-6BxHaaQ0D7bn5k-NRlQ.png"
        ) {
            Log.d("DEBG", "id 2 clicked")
        },
        PrimaryCategoryItem(
            "id 3",
            "Physics",
            "https://upload.wikimedia.org/wikipedia/commons/5/57/Galunggung.jpg"
        ) {
            Log.d("DEBG", "id 3 clicked")
        },
        PrimaryCategoryItem(
            "id 4",
            "Psychology",
            "https://cdn-images-1.medium.com/max/800/1*xueefr-T7KKDGSPx20lPGg.png"
        ) {
            Log.d("DEBG", "id 4 clicked")
        }
    )
}
