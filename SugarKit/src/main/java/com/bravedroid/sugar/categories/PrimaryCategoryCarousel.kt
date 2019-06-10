package com.bravedroid.sugar.categories

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bravedroid.sugar.R
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
    ListAdapter<PrimaryCategoryItem, PrimaryCategoriesAdapter.ViewHolder>(
        ItemDiff
    ) {
    var onSeeMoreClicked: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
                ViewHolder(imageView)
            }

            NORMAL_ITEM_TYPE -> {
                ViewHolder(
                    PrimaryCategoryCardView(parent.context).apply {
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
            else -> throw IllegalStateException("no such type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == itemCount - 1) return LAST_ITEM_TYPE
        return NORMAL_ITEM_TYPE
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
//            holder.container.setOnClickListener { item.listener(item.id) }
//            holder.titleTextView.text = item.title
//            holder.subtitleTextView.text = item.subtitle
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            val container: LinearLayout = view.itemContainer
//            val titleTextView: TextView = view.title
//            val subtitleTextView: TextView = view.subtitle
    }

    private object ItemDiff : DiffUtil.ItemCallback<PrimaryCategoryItem>() {
        override fun areItemsTheSame(
            oldItemPrimary: PrimaryCategoryItem,
            newItemPrimary: PrimaryCategoryItem
        ): Boolean {
            return oldItemPrimary.id == newItemPrimary.id
        }

        override fun areContentsTheSame(
            oldItemPrimary: PrimaryCategoryItem,
            newItemPrimary: PrimaryCategoryItem
        ): Boolean {
            return oldItemPrimary == newItemPrimary
        }
    }
}
