package com.example.progettoium.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.progettoium.view.navFragment.FirstFragment
import com.example.progettoium.R
import com.example.progettoium.view.navFragment.SecondFragment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.ibrahimsn.lib.SmoothBottomBar


class HomePage : Fragment() {

    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tabLayout : TabLayout = view.findViewById(R.id.first_tab_layout)


        demoCollectionAdapter = DemoCollectionAdapter(this)
        viewPager = view.findViewById(R.id.page_view)
        viewPager.adapter = demoCollectionAdapter



        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Pagina ${(position + 1)}"
        }.attach()




    }


}



class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = DemoObjectFragment(position)
        fragment.arguments = Bundle().apply {
            if(position == 0){
                val arrayList = listOf(
                    "Benvenuto",
                    "Wewe sei nella prima pagina",
                    "Chip1"
                )
                putStringArrayList(ARG_OBJECT, ArrayList(arrayList)) }
            if(position == 1){
                val arrayList = listOf(
                    "Benvenuto",
                    "Wewe sei nella seconda pagina",
                    "Chip2"
                )
                putStringArrayList(ARG_OBJECT, ArrayList(arrayList))
            }
            if(position == 2){
                val arrayList = listOf(
                    "Benvenuto",
                    "Wewe sei nella terza pagina",
                    "Chip3"
                )
                putStringArrayList(ARG_OBJECT, ArrayList(arrayList))
            }
        }
        return fragment
    }
}

private const val ARG_OBJECT = "object"

// Instances of this class are fragments representing a single
// object in our collection.
class DemoObjectFragment(position : Int) : Fragment() {

    private val index : Int = position

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val card : MaterialCardView = view.findViewById(R.id.card)

        val titleCard : TextView = view.findViewById(R.id.card_title)
        val textCard : TextView = view.findViewById(R.id.card_text)

        val button1Card : Button = view.findViewById(R.id.card_button1)
        val button2Card : Button = view.findViewById(R.id.card_button2)

        if(index == 0){
            titleCard.text = "Giornata 7"
            textCard.text = "Torino vs Juventus"

            button1Card.setOnClickListener {
                Toast.makeText(context,"Giocano sabato 2 ottobre alle ore 18:00",Toast.LENGTH_LONG).show()
            }
            button2Card.setOnClickListener {
                Toast.makeText(context,"Ok te lo ricorderò",Toast.LENGTH_SHORT).show()
            }
        }
        if(index == 1){
            card.visibility =View.INVISIBLE
        }

        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textView1: TextView = view.findViewById(R.id.textTest)
            val textView2: TextView = view.findViewById(R.id.textTest2)
            val chip: Chip = view.findViewById(R.id.chip)

            textView1.text = getStringArrayList(ARG_OBJECT)?.elementAt(0)
            textView2.text = getStringArrayList(ARG_OBJECT)?.elementAt(1)
            chip.text = getStringArrayList(ARG_OBJECT)?.elementAt(2)
        }
    }
}