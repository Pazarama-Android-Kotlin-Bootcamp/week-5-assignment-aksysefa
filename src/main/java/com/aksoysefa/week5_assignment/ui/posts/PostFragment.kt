package com.aksoysefa.week5_assignment.ui.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.aksoysefa.week5_assignment.databinding.FragmentPostBinding
import com.aksoysefa.week5_assignment.ui.loadingprocess.LoadingProgressBar
import com.aksoysefa.week5_assignment.ui.model.DataState
import com.aksoysefa.week5_assignment.ui.model.PostDTO
import com.aksoysefa.week5_assignment.ui.posts.adapter.OnPostClickListener
import com.aksoysefa.week5_assignment.ui.posts.adapter.PostsAdapter
import com.aksoysefa.week5_assignment.ui.posts.viewmodel.PostViewEvent
import com.aksoysefa.week5_assignment.ui.posts.viewmodel.PostsViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class PostsFragment : Fragment(), OnPostClickListener {
    lateinit var loadingProgressBar: LoadingProgressBar
    private lateinit var binding: FragmentPostBinding
    private val viewModel by viewModels<PostsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingProgressBar = LoadingProgressBar(requireContext())
        binding.viewModel=viewModel as PostsFragment
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.postLiveData.observe(viewLifecycleOwner){
            when(it){
                is DataState.Success -> {
                    loadingProgressBar.hide()
                    it.data?.let { safeData->
                        binding.rvPostsList.adapter = PostsAdapter(this).apply {
                            submitList(safeData)
                        }
                    } ?: run {
                        Toast.makeText(requireContext(),"No data", Toast.LENGTH_SHORT).show()
                    }
                }
                is DataState.Error -> {
                    loadingProgressBar.hide()
                    Snackbar.make(binding.root,it.message, Snackbar.LENGTH_LONG).show()

                }
                is DataState.Loading -> {
                    loadingProgressBar.show()
                }
            }
        }

        viewModel.eventStateLiveData.observe(viewLifecycleOwner){
            when (it) {
                is PostViewEvent.ShowMessage -> {}
                is PostViewEvent.NavigateToDetail -> {}
            }
        }
    }

    override fun onPostClick(post: PostDTO) {
        viewModel.onFavoritePost(post)
    }


}