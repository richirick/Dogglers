package com.example.dogglers.adapter

//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.dogglers.R
//import com.example.dogglers.const.Layout
//import com.example.dogglers.data.DataSource
//import com.example.dogglers.model.Dog
//
///**
// * Adapter to inflate the appropriate list item layout and populate the view with information
// * from the appropriate data source
// */
//class DogCardAdapter(
//    private val context: Context?,
//    private val layout: Int
////    private val dogs: List<Dog>,
////    private val dataSource: List<DataSource>
//): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
//
//    // TODO: Initialize the data using the List found in data/DataSource
//
//    private val dogList = DataSource.dogs
//    /**
//     * Initialize view elements
//     */
//    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
//        val dogname: TextView? = view?.findViewById(R.id.dog_name)
//        val dogage: TextView? = view?.findViewById(R.id.dog_age)
//        val doghobbies: TextView? = view?.findViewById(R.id.dog_hobbies)
//        val imageView: ImageView? = view?.findViewById(R.id.dog_image)
//        // TODO: Declare and initialize all of the list item UI components
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
//        val layoutType = when(layout){
//            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
//            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
////            Layout.HORIZONTAL -> R.layout.vertical_horizontal_list_item
////            else -> R.layout.vertical_horizontal_list_item
//        }
////        val layoutType = if(layout == Layout.GRID) R.layout.grid_list_item else R.layout.vertical_horizontal_list_item
////        val adapterLayout = LayoutInflater.from(parent.context)
////            .inflate(layoutType, parent, false)
////        val gridLayout = LayoutInflater.from(parent.context)
////            .inflate(R.layout.grid_list_item, parent, false)
////        val adapterLayout = LayoutInflater.from(parent.context)
////            .inflate(R.layout.vertical_horizontal_list_item, parent, false)
//        // TODO: Use a conditional to determine the layout type and set it accordingly.
//        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
//        //  the vertical/horizontal list item should be used.
//
//        // TODO Inflate the layout
//
//        // TODO: Null should not be passed into the view holder. This should be updated to reflect
//        //  the inflated layout.
//        return DogCardViewHolder(layoutType)
//    }
//
//    override fun getItemCount(): Int = dogList.size
//
//    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
//        val data = dogList[position]
//        // TODO: Get the data at the current position
//        // TODO: Set the image resource for the current dog
//        // TODO: Set the text for the current dog's name
//        // TODO: Set the text for the current dog's age
//        val resources = context?.resources
//        holder.imageView!!.setImageResource(data.imageResourceId)
//        holder.dogname!!.text = data.name
//        holder.dogage!!.text = resources?.getString(R.string.dog_age, data.age)
//        holder.doghobbies!!.text = resources?.getString(R.string.dog_hobbies, data.hobbies)
//        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
//        //  R.string.dog_hobbies string constant.
//        //  Passing an argument to the string resource looks like:
//        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
//    }
//}
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // Initialize the data using the List found in data/DataSource
    private val dogList = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
        val dogImageView: ImageView? = view!!.findViewById(R.id.dog_image)
        val dogNameTextView: TextView? = view!!.findViewById(R.id.dog_name)
        val dogAgeTextView: TextView? = view!!.findViewById(R.id.dog_age)
        val dogHobbyTextView: TextView? = view!!.findViewById(R.id.dog_hobby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        //  Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val adapterLayout = when (layout) {
            // Inflate the layout
            GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }

        //  Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dogList.size
    } // return the size of the data set

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // Get the data at the current position
        val dogData = dogList[position]
        // Set the image resource for the current dog
        holder.dogImageView?.setImageResource(dogData.imageResourceId)
        // Set the text for the current dog's name
        holder.dogNameTextView?.text = dogData.name
        // Set the text for the current dog's age
        val resources = context?.resources
        holder.dogAgeTextView?.text = resources?.getString(R.string.dog_age, dogData.age)
        // Set the text for the current dog's hobbies by passing the hobbies to the
        // R.string.dog_hobbies string constant.
        // Passing an argument to the string resource looks like:
        // resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dogHobbyTextView?.text = resources?.getString(R.string.dog_hobbies, dogData.hobbies)
    }
}
