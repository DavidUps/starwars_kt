package com.example.davidarribas.starwars.view

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Film
import com.flaviofaria.kenburnsview.RandomTransitionGenerator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_film.*
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.davidarribas.starwars.model.ImagesUrl
import com.squareup.picasso.Callback
import java.lang.Exception


class FilmFragment : Fragment() {

    lateinit var film: Film
    lateinit var animationDrawable: AnimationDrawable

    companion object {
        fun newInstance(film: Film): FilmFragment {
            val fragment = FilmFragment()
            val args = Bundle()
            args.putSerializable("films", film)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        film = arguments!!.getSerializable("films") as Film
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage()
        setText()
        val ACCELERATE_DECELERATE = AccelerateDecelerateInterpolator()
        val generator = RandomTransitionGenerator(10000, ACCELERATE_DECELERATE)
        imView.setTransitionGenerator(generator)
    }

    private fun setImage() {

        clProgressBarFilm.visibility = View.VISIBLE
        ivProgressBar.setBackgroundResource(R.drawable.load_progressbar)
        animationDrawable = ivProgressBar.background as AnimationDrawable
        animationDrawable.start()

        when (film.episode_id) {
            1 -> {
                Picasso.get().load(ImagesUrl.filmEpI).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
            2 -> {
                Picasso.get().load(ImagesUrl.filmEpII).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
            3 -> {
                Picasso.get().load(ImagesUrl.filmEpIII).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
            4 -> {
                Picasso.get().load(ImagesUrl.filmEpIV).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
            5 -> {
                Picasso.get().load(ImagesUrl.filmEpV).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
            6 -> {
                Picasso.get().load(ImagesUrl.filmEpVI).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
            7 -> {
                Picasso.get().load(ImagesUrl.filmEpVII).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
            else -> {
                Picasso.get().load(ImagesUrl.filmDefault).into(imView, object : Callback {
                    override fun onSuccess() {
                        clProgressBarFilm.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        clProgressBarFilm.visibility = View.GONE
                    }

                })
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText() {
        tvTitle.text = film.title
        tvDirector.text = "Director: " + film.director
        tvProducer.text = "Productor: " + film.producer
        tvReleaseDate.text = "Estreno: " + film.release_date
        tvOpening.text = film.opening_crawl
    }
}