package com.example.instapaulina;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instapaulina.Models.Post;

import org.parceler.Parcels;

public class PostDetailsActivity extends AppCompatActivity {

    ImageView ivPost;
    ImageView ivProfileImage;
    TextView tvUsername;
    TextView tvDescription;
    TextView tvUsernameB;
    TextView tvCreatedAt;

    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        ivPost = findViewById(R.id.ivPostD);
        ivProfileImage = findViewById(R.id.ivProfileImageD);
        tvUsername = findViewById(R.id.tvUsernameD);
        tvDescription = findViewById(R.id.tvDescriptionD);
        tvUsernameB = findViewById(R.id.tvUsernameBottom);
        tvCreatedAt = findViewById(R.id.tvCreatedAt);

        post = Parcels.unwrap(getIntent().getParcelableExtra("post"));

        Glide.with(this).load(post.getImage().getUrl()).into(ivPost);
        tvUsername.setText(post.getUser().getUsername());
        tvDescription.setText(post.getDescription());
        tvUsernameB.setText(post.getUser().getUsername());
        tvCreatedAt.setText(Post.calculateTimeAgo(post.getCreatedAt()));
    }
}