package com.bravedroid.sugarplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bravedroid.sugar.categories.PrimaryCategoryCarousel
import com.bravedroid.sugar.categories.PrimaryCategoryItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<PrimaryCategoryCarousel>(R.id.carousel).setCategories(primaryCategoryItems)
    }

    private val primaryCategoryItems = listOf(
        PrimaryCategoryItem(id = "id 1", title = "Math"),
        PrimaryCategoryItem(id = "id 2", title = "Algebra"),
        PrimaryCategoryItem(id = "id 3", title = "Physics"),
        PrimaryCategoryItem(id = "id 4", title = "Psychology")
    )
}
//        override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val recyclerView = findViewById<RecyclerView>(R.id.categories_recyclerView)
//        val categoriesAdapter = PrimaryCategoriesAdapter()
//        recyclerView.adapter = categoriesAdapter
//        categoriesAdapter.submitList(items)
//    }
//
//    private val items = listOf(
//        PrimaryCategoryItem(id = "id 1", title = "title 1", subtitle = "title 1"),
//        PrimaryCategoryItem(id = "id 1", title = "title 1", subtitle = "title 1"),
//        PrimaryCategoryItem(id = "id 1", title = "title 1", subtitle = "title 1"),
//        PrimaryCategoryItem(id = "id 2", title = "title 2", subtitle = "title 2")
//    )
//
//    private data class PrimaryCategoryItem(
//        val id: String,
//        val title: String,
//        val subtitle: String
//    )
//
//    private class PrimaryCategoriesAdapter :
//        ListAdapter<PrimaryCategoryItem, PrimaryCategoriesAdapter.ViewHolder>(ItemDiff) {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//            val inflate = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
//            return ViewHolder(inflate)
////            return ViewHolder(
////                PrimaryCategoryCardView(parent.context).apply {
////                    layoutParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
////                        .also {
////                            it.setMargins(10)
////                        }
////                }
////            )
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            val item = getItem(position)
////            holder.container.setOnClickListener { item.listener(item.id) }
////            holder.titleTextView.text = item.title
////            holder.subtitleTextView.text = item.subtitle
//        }
//
//        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
////            val container: LinearLayout = view.itemContainer
////            val titleTextView: TextView = view.title
////            val subtitleTextView: TextView = view.subtitle
//        }
//
//        private object ItemDiff : DiffUtil.ItemCallback<PrimaryCategoryItem>() {
//            override fun areItemsTheSame(oldItem: PrimaryCategoryItem, newItem: PrimaryCategoryItem): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: PrimaryCategoryItem, newItem: PrimaryCategoryItem): Boolean {
//                return oldItem == newItem
//            }
//
//        }
//    }
//}
