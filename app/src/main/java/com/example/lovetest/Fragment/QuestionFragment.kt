package com.example.lovetest.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentMainBinding
import com.example.lovetest.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //바인딩 초기화
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        // 원래 레이아웃뷰 반환은 이거지만 바인딩 사용하므로 바꿔줌
        //return inflater.inflate(R.layout.fragment_question, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostController =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostController.navController

        binding.btnNext2.setOnClickListener {
            navController.navigate(R.id.action_questionFragment_to_selectionFragment)
        }
    }

}