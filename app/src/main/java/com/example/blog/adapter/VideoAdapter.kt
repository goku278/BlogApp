package com.example.blog.adapter

import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.blog.model.VideoFiles
import com.example.blog.util.NetworkUtil
import com.example.blogapp.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class VideoAdapter(private val videos: List<VideoFiles>, private val context: Context) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    private var nwAvailable = true
    init {
        if (!NetworkUtil.isInternetAvailable(context)) {
            nwAvailable = false
        }
    }

    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playerView: PlayerView = view.findViewById(R.id.playerView)
        val thumbnailView: ImageView = view.findViewById(R.id.thumbnailView)
        var player: SimpleExoPlayer? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        val videoUri = Uri.parse(video.link)

        if (nwAvailable) {
            holder.playerView.isVisible = true
            holder.thumbnailView.isVisible = false
        }
        else {
            holder.playerView.isVisible = false
            holder.thumbnailView.isVisible = true
        }

        // Ensure thumbnail is visible initially
//        holder.thumbnailView.visibility = View.VISIBLE

        // Load thumbnail using Glide
        Glide.with(context)
            .load(video.thumbNails) // Replace with the actual thumbnail URL
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.thumbnailView)

        // Release the player if it exists
        holder.player?.release()
        holder.player = null

        // Check network connectivity
        if (isNetworkAvailable(context)) {
            holder.thumbnailView.visibility = View.GONE
            holder.playerView.visibility= View.VISIBLE
            holder.player = SimpleExoPlayer.Builder(context).build()
            holder.playerView.player = holder.player
            val mediaItem = MediaItem.fromUri(videoUri)
            holder.player?.setMediaItem(mediaItem)
            holder.player?.prepare()

            // Hide the thumbnail when video starts playing
            holder.player?.addListener(object : Player.Listener {
                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    if (isPlaying) {
                        holder.thumbnailView.visibility = View.GONE
                    }
                }

                override fun onPlaybackStateChanged(state: Int) {
                    if (state == Player.STATE_READY && holder.player?.isPlaying == true) {
                        holder.thumbnailView.visibility = View.GONE
                    } else if (state == Player.STATE_ENDED || state == Player.STATE_IDLE) {
                        holder.thumbnailView.visibility = View.VISIBLE
                    }
                }
            })

            holder.player?.play()
        } else {
            holder.thumbnailView.visibility = View.VISIBLE
            holder.playerView.visibility= View.GONE
            holder.thumbnailView.setOnClickListener {
                Toast.makeText(context, "Please turn ON wifi/data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewRecycled(holder: VideoViewHolder) {
        super.onViewRecycled(holder)
        holder.player?.release()
        holder.player = null
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        return NetworkUtil.isInternetAvailable(context)
    }
}
