package com.example.zoopractice.detail

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.zoopractice.MainActivity
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragDetailBinding
import com.example.zoopractice.main.MainFragmentDirections

class DetailFragment : Fragment()  {

    companion object {
        private const val CHANNEL_ID = "com.example.zoopractice"
        private const val notificationId = 8
    }

    private val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragDetailBinding>(inflater, R.layout.frag_detail, container, false)

        binding.apply {
//          方法一：receives arguments from bundle
//            results = arguments?.getParcelable("data")

            results = arguments?.let { DetailFragmentArgs.fromBundle(it).data }
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
            fragment = this@DetailFragment
            executePendingBindings()

            val title = results?.name
            title?.let {
                (activity as MainActivity).updateToolbar(it)
            }
        }

        return binding.root
    }

    fun send() {
        activity?.let {
            if (VERSION.SDK_INT >= VERSION_CODES.O) {
                val channel = NotificationChannel(CHANNEL_ID, "ChannelName", NotificationManager.IMPORTANCE_DEFAULT)
                channel.description = "description"
                val notificationManager: NotificationManager = it.getSystemService(NotificationManager::class.java)
                notificationManager.createNotificationChannel(channel)
            }

            val builder: NotificationCompat.Builder =
                NotificationCompat.Builder(it, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.feedback)
                    .setContentTitle("DeepLinkDemo")
                    .setContentText("Click to send feedback!!")
                    .setVibrate(longArrayOf(500, 500, 1000, 2000, 3000, 500, 500, 500))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(getPendingIntent())
                    .setAutoCancel(true)

            val notificationManager = NotificationManagerCompat.from(it)
            notificationManager.notify(notificationId, builder.build())
        }
    }

    private fun getPendingIntent(): PendingIntent? {
        activity?.let {
            val bundle = Bundle()
            bundle.putString("params", "Notification")
            return Navigation
                .findNavController(it, R.id.btn_send_notification)
                .createDeepLink()
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.feedBackFragment)
                .setArguments(bundle)
                .createPendingIntent()
        }

        return null
    }

    fun goNextPage() {
        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToHelloFragment())
    }
}