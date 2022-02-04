package com.kemalurekli.recyclerviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kemalurekli.recyclerviewexample.adapter.RecyclerviewAdapter
import com.kemalurekli.recyclerviewexample.databinding.FragmentHomeBinding
import com.kemalurekli.recyclerviewexample.model.ContentModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val contents = MutableLiveData<List<ContentModel>>()
    private val recyclerviewAdapter = RecyclerviewAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHomeFragment.layoutManager = LinearLayoutManager(context)
        binding.rvHomeFragment.adapter = recyclerviewAdapter
        loadData()
        observeData()
    }


    private fun loadData () {
        val content1 = ContentModel("1. ","This is a first row")
        val content2 = ContentModel("2. ","This is a second row")
        val content3 = ContentModel("3. ","This is a third row")
        val content4 = ContentModel("4. ","This is a fourth row")
        val content5 = ContentModel("5. ","This is a fifth row")
        val content6 = ContentModel("6. ","This is a sixth row")
        val content7 = ContentModel("7. ","This is a seventh row")
        val content8 = ContentModel("8. ","This is a eighth row")
        val content9 = ContentModel("9. ","This is a ninth row")
        val content10 = ContentModel("10. ","This is a tenth row")
        val contentList = arrayListOf<ContentModel>(content1,content2,content3,content4,content5,content6,content7,content8,content9,content10)
        contents.value = contentList

    }


    fun observeData () {
        contents.observe(viewLifecycleOwner, Observer {contents->
            contents.let {
                recyclerviewAdapter.updateContentList(contents)
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}