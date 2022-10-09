package com.laioffer.tinnews.ui.save;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.FragmentSaveBinding;
import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.repository.NewsRepository;
import com.laioffer.tinnews.repository.NewsViewModelFactory;

public class SaveFragment extends Fragment {
  private FragmentSaveBinding binding;
  private SaveViewModel viewModel;

  public SaveFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    binding =  FragmentSaveBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    SaveNewsAdapter saveNewsAdapter = new SaveNewsAdapter();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
    binding.newsSavedRecyclerView.setLayoutManager(linearLayoutManager);
    binding.newsSavedRecyclerView.setAdapter(saveNewsAdapter);

    saveNewsAdapter.setItemCallback(new SaveNewsAdapter.ItemCallback() {
      @Override
      public void onOpenDetails(Article article) {
        SaveFragmentDirections.ActionNavigationSaveToNavigationDetails
                direction = SaveFragmentDirections.actionNavigationSaveToNavigationDetails(article);
        NavHostFragment.findNavController(SaveFragment.this).navigate(direction);
      }

      @Override
      public void onRemoveFavorite(Article article) {
        viewModel.deleteSavedArticle(article);
      }
    });
    NewsRepository repository = new NewsRepository();
    viewModel = new ViewModelProvider(this, new NewsViewModelFactory(repository))
            .get(SaveViewModel.class);
    viewModel.getAllSavedArticles().observe(getViewLifecycleOwner(), articles -> {
      if (articles != null) {
        Log.d("SaveFragment", articles.toString());
        saveNewsAdapter.setArticles(articles);
      }
    });
  }
}