package com.bravedroid.sugar

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.card.MaterialCardView


class CategoryCardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    MaterialCardView(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_primary_category_card_view, this)
        val width = resources.getDimension(R.dimen.category_card_width).toInt()
        val height = resources.getDimension(R.dimen.category_card_height).toInt()
        layoutParams = LayoutParams(width, height)
        foregroundGravity = Gravity.CENTER
        radius = resources.getDimension(R.dimen.category_card_radius)


        val imageThumbnail = findViewById<ImageView>(R.id.thumbnail)
        // OK//   imageThumbnail.setImageDrawable(resources.getDrawable(R.drawable.box_categoriedu_jour, null))

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CategoryCardView)
        val imageUrl = attributes.getString(R.styleable.CategoryCardView_imageUrl)
        val titleText = attributes.getString(R.styleable.CategoryCardView_titleText)
        attributes.recycle()

        Glide.with(context)
            //.load(R.drawable.box_categoriedu_jour)
            .load(
                imageUrl ?: "https://s3-media1.fl.yelpcdn.com/bphoto/zSa_TYUZbsisSxLYkNEJuQ/l.jpg"
            )
            .apply(
                RequestOptions()
                    .override(
                        resources.getDimensionPixelSize(R.dimen.category_card_width),
                        resources.getDimensionPixelSize(R.dimen.category_card_height)
                    )
                    .placeholder(ColorDrawable(Color.GRAY))
            )
            .into(imageThumbnail)

        findViewById<TextView>(R.id.item_title).text = titleText ?: "Title".toUpperCase()
    }
}
