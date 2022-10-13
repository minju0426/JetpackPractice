package com.example.lovetest.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    var option = -1
    lateinit var navController: NavController
    lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        option = arguments?.getInt("index") ?: -1 //만약null이 전달되면 -1

        binding = FragmentResultBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostController =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostController.navController

       binding.btnHome.setOnClickListener {
           navController.navigate(R.id.action_resultFragment_to_mainFragment)
       }

        setResult(option)

    }

    fun setResult(option: Int) {
        when (option) {
            1 -> {
                binding.tvMain.text = "당신은 쉽게 포기하는 성향"
                binding.tvSub.text = "조금만 끈기를 가지고 도전해보는건 어떨까요?"

            }
            2 -> {
                binding.tvMain.text = "당신은 헌신적인 성향"
                binding.tvSub.text = "조금만 자기자신에게 더 집중해보세요"
            }
            3 -> {
                binding.tvMain.text = "당신은 충동적인 성향"
                binding.tvSub.text = "조금만 릴렉스~진정해보세요"
            }
            4 -> {
                binding.tvMain.text = "당신은 성숙한 사람입니다"
                binding.tvSub.text = "현실을 쉽게 받아들이고\n\n\n미래를 바라보는 타입이네요"
            }

        }
    }

}