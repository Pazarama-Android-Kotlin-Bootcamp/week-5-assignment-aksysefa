package com.aksoysefa.week5_assignment.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.aksoysefa.week5_assignment.R
import com.aksoysefa.week5_assignment.databinding.FragmentFavoritesBinding
import com.aksoysefa.week5_assignment.databinding.FragmentUsersBinding
import com.aksoysefa.week5_assignment.ui.favorite.adapter.FavoritesAdapter
import com.aksoysefa.week5_assignment.ui.favorite.adapter.OnFavoriteClickListener
import com.aksoysefa.week5_assignment.ui.favorite.viewmodel.FavoritesViewModel
import com.aksoysefa.week5_assignment.ui.loadingprocess.LoadingProgressBar
import com.aksoysefa.week5_assignment.ui.model.DataState
import com.aksoysefa.week5_assignment.ui.model.PostDTO
import com.aksoysefa.week5_assignment.ui.users.adapter.UsersAdapter
import com.aksoysefa.week5_assignment.ui.users.viewmodel.UserViewEvent
import com.aksoysefa.week5_assignment.ui.users.viewmodel.UsersViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(), OnFavoriteClickListener {
    lateinit var loadingProgressBar: LoadingProgressBar
    private val viewModel by viewModels<FavoritesViewModel>()
    private lateinit var binding: FragmentFavoritesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingProgressBar = LoadingProgressBar(requireContext())

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.postLiveData.observe(viewLifecycleOwner) {

            binding.rvFavoritesList.adapter = FavoritesAdapter(this).apply {
                submitList(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getPosts()
    }

    override fun onFavoriteClick(post: PostDTO) {
        viewModel.onFavoritePost(post)
    }


}
