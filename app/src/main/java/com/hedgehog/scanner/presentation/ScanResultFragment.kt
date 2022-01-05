package com.hedgehog.scanner.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.hedgehog.scanner.R
import com.hedgehog.scanner.data.AppImageNameRepository
import com.hedgehog.scanner.domain.usecases.GetAppsImageAndNameUseCase

class ScanResultFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var appAdapter: AppsRecyclerAdapter

    private val appImageNameRepository by lazy {
        AppImageNameRepository(requireActivity().application)
    }

    private val getAppsImageAndNameUseCase by lazy {
        GetAppsImageAndNameUseCase(appImageNameRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("QWE", "onCreateView: ")
        return inflater.inflate(R.layout.scan_result_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = getAppsImageAndNameUseCase.execute()
        recyclerView = view.findViewById(R.id.recycler)
        appAdapter = AppsRecyclerAdapter(requireContext(), list)
        recyclerView.adapter = appAdapter
    }

}