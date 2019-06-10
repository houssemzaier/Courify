package com.bravedroid.sugar

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


class PrimaryCategoriesCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) :
    LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_carousel_primary_catogories, this)
        setBackgroundColor(Color.WHITE)
        orientation = VERTICAL

        val recyclerView = findViewById<RecyclerView>(R.id.categories_recyclerView)
        val categoriesAdapter = CategoriesAdapter()
        recyclerView.adapter = categoriesAdapter
        categoriesAdapter.submitList(items)
    }

}

private val items = listOf(
    CategoryItem(id = "id 1", title = "title 1", subtitle = "title 1"),
    CategoryItem(id = "id 1", title = "title 1", subtitle = "title 1"),
    CategoryItem(id = "id 1", title = "title 1", subtitle = "title 1"),
    CategoryItem(id = "id 2", title = "title 2", subtitle = "title 2")
)

private data class CategoryItem(
    val id: String,
    val title: String,
    val subtitle: String
)

private class CategoriesAdapter :
    ListAdapter<CategoryItem, CategoriesAdapter.ViewHolder>(ItemDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        //return ViewHolder(inflate)
        return ViewHolder(
            CategoryCardView(parent.context).apply {
                layoutParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
                    .also {
                        it.rightMargin =
                            resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                        it.topMargin =
                            resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                    }
            }
        )
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

    private object ItemDiff : DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem == newItem
        }

    }
}
