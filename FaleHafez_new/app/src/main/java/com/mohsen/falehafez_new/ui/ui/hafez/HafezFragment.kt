package com.mohsen.falehafez_new.ui.ui.hafez


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnLayout
import androidx.recyclerview.widget.LinearLayoutManager

import com.mohsen.falehafez_new.R
import com.mohsen.falehafez_new.adapter.PoemAdapter
import com.mohsen.falehafez_new.util.ResourceHelper
import kotlinx.android.synthetic.main.fragment_hafez.*

/**
 * A simple [Fragment] subclass.
 */
class HafezFragment : Fragment() {

    lateinit var adapter: PoemAdapter
    var items: List<String> = ArrayList()
    var evaluate: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hafez, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        poemDescriptionHolder.doOnLayout {

        }
        items = ResourceHelper.getInstance(activity!!).getPoems()
        evaluate = ResourceHelper.getInstance(activity!!).getEvaluate()




        PoemInterpretationTv.text = evaluate


        adapter = PoemAdapter(activity!!, items)

        poemRecycler.layoutManager = LinearLayoutManager(activity!!)

        poemRecycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        items = ResourceHelper.getInstance(activity!!).getPoems()
        evaluate = ResourceHelper.getInstance(activity!!).getEvaluate()
    }

    override fun onStart() {
        super.onStart()
        items = ResourceHelper.getInstance(activity!!).getPoems()
        evaluate = ResourceHelper.getInstance(activity!!).getEvaluate()
    }
}
