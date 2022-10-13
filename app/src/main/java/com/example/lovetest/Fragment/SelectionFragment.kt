package com.example.lovetest.Fragment

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentSelectionBinding

class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var binding: FragmentSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //바인딩 초기화
        binding = FragmentSelectionBinding.inflate(inflater, container, false)
        // 원래 레이아웃뷰 반환은 이거지만 바인딩 사용하므로 바꿔줌
        //return inflater.inflate(R.layout.fragment_question, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostController =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostController.navController

        binding.btnPre.setOnClickListener(this)
        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_pre -> {
                navController.popBackStack()
            }
            R.id.option1 -> {
                navigateWithIndex(1)
            }
            R.id.option2 -> {
                navigateWithIndex(2)
            }
            R.id.option3 -> {
                navigateWithIndex(3)
            }
            R.id.option4 -> {
                navigateWithIndex(4)
            }

        }
    }

    fun navigateWithIndex(idx: Int) {
        // val bundle2:Bundle= bundleOf("index" to i)

        val bundle = Bundle()
        bundle.putInt("index",idx)

        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }
}

