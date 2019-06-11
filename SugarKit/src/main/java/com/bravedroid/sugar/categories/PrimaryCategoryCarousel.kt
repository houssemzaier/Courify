package com.bravedroid.sugar.categories

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bravedroid.sugar.R
import com.google.android.material.card.MaterialCardView
import java.lang.IllegalStateException

private const val LAST_ITEM_TYPE = 0
private const val NORMAL_ITEM_TYPE = 1

class PrimaryCategoryCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) :
    LinearLayout(context, attrs) {

    private val categoriesAdapter = PrimaryCategoriesAdapter()

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_primary_catogory_carousel, this)
        setBackgroundColor(Color.WHITE)
        orientation = VERTICAL

        val recyclerView = findViewById<RecyclerView>(R.id.categories_recyclerView)
        recyclerView.adapter = categoriesAdapter
    }

    fun setCategories(
        primaryCategoryItems: List<PrimaryCategoryItem>,
        onSeeMoreClicked: (() -> Unit)? = null
    ) {
        categoriesAdapter.submitList(primaryCategoryItems)
        categoriesAdapter.onSeeMoreClicked = onSeeMoreClicked
    }
}


private class PrimaryCategoriesAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var primaryCategoryItems = listOf<PrimaryCategoryItem>()


    var onSeeMoreClicked: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            LAST_ITEM_TYPE -> {
                val imageView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_primary_category_more, parent, false)
                imageView.apply {
                    layoutParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
                        .also {
                            it.rightMargin =
                                resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                            it.topMargin =
                                resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                        }
                    setOnClickListener {
                        onSeeMoreClicked?.invoke()
                    }
                }
                SeeMoreViewHolder(imageView)
            }

            NORMAL_ITEM_TYPE -> {
                PrimaryCategoryViewHolder(
                    PrimaryCategoryCardView(parent.context)
                        .apply {
                            layoutParams =
                                FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
                                    .also {
                                        it.rightMargin =
                                            resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                                        it.topMargin =
                                            resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                                    }
                        }

                )
            }
            else -> {
                throw IllegalStateException("no such type")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == itemCount - 1) return LAST_ITEM_TYPE
        return NORMAL_ITEM_TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            LAST_ITEM_TYPE -> {
            }
            NORMAL_ITEM_TYPE -> {
                val item = getItem(position)
                holder as PrimaryCategoryViewHolder
                holder.title.text = item.title
                if (item.categoryThumbnailUrl != null)
                    holder.container.loadImageUrl(item.categoryThumbnailUrl)

                holder.container.setOnClickListener {
                    item.onClick?.invoke()
                }
            }
            else -> {
                throw IllegalStateException("no such type")
            }
        }
    }

    override fun getItemCount(): Int = primaryCategoryItems.size + 1

    fun submitList(primaryCategoryItems: List<PrimaryCategoryItem>) {
        this.primaryCategoryItems = primaryCategoryItems
        notifyDataSetChanged()
    }

    fun getItem(position: Int): PrimaryCategoryItem = primaryCategoryItems[position]


    private class SeeMoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      //   val container: LinearLayout = view.itemContainer
      //   val titleTextView: TextView = view.title
      //   val subtitleTextView: TextView = view.subtitle
    }

    private class PrimaryCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var title = view.findViewById<TextView>(R.id.category_title)
        var thumbnail = view.findViewById<ImageView>(R.id.category_thumbnail)
        var container = view.findViewById<PrimaryCategoryCardView>(R.id.category_container)

//            val container: LinearLayout = view.itemContainer
//            val titleTextView: TextView = view.title
//            val subtitleTextView: TextView = view.subtitle
    }


}
