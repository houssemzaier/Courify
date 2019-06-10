package com.bravedroid.sugar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

private const val LAST_ITEM_TYPE = 0
private const val NORMAL_ITEM_TYPE = 1

class PrimaryCategoriesCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) :
    LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_primary_catogory_carousel, this)
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
        if (viewType == LAST_ITEM_TYPE) {
//         val imageView = ImageView(parent.context)
//             .apply {
//                 layoutParams = FrameLayout.LayoutParams(
//                     parent.context.resources.getDimensionPixelSize(R.dimen.category_card_more_width),
//                     parent.context.resources.getDimensionPixelSize(R.dimen.category_card_more_height)
//                 ).also {
//                     //                    it.rightMargin =
// //                    resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
//                     it.topMargin =
//                         resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
//                 }
//                 setImageResource(R.drawable.ic_box_categorie_voir_plus)
//             }
//
//         //   Glide.with(parent.context)
//         //       .load(R.drawable.ic_box_categorie_voir_plus)
//         //       .into(imageView)
            val imageView = LayoutInflater.from(parent.context).inflate(R.layout.a, parent, false)
            imageView.apply {
                layoutParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
                    .also {
                        it.rightMargin =
                            resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                        it.topMargin =
                            resources.getDimensionPixelSize(R.dimen.primary_categories_margin)
                    }
            }

            return ViewHolder(imageView)
        }

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

    private object ItemDiff : DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem == newItem
        }

    }
}
