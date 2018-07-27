package com.example.davidarribas.starwars.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Film
import com.flaviofaria.kenburnsview.RandomTransitionGenerator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_film.*
import android.R.interpolator
import android.R.attr.duration
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.davidarribas.starwars.model.ImagesUrl


class FilmFragment : Fragment() {

    lateinit var film : Film

    companion object {
        fun newInstance(film: Film) : FilmFragment{
            val fragment = FilmFragment()
            val args = Bundle()
            args.putParcelable("films", film)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        film = arguments!!.getParcelable("films")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_film, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage()
        setText()
        val ACCELERATE_DECELERATE = AccelerateDecelerateInterpolator()
        val generator = RandomTransitionGenerator(10000, ACCELERATE_DECELERATE)
        imView.setTransitionGenerator(generator)
    }

    private fun setImage(){
        when (film.episode_id){
            1 -> Picasso.get().load(ImagesUrl.filmEpI).into(imView)
            2 -> Picasso.get().load(ImagesUrl.filmEpII).into(imView)
            3 -> Picasso.get().load(ImagesUrl.filmEpIII).into(imView)
            4 -> Picasso.get().load(ImagesUrl.filmEpIV).into(imView)
            5 -> Picasso.get().load(ImagesUrl.filmEpV).into(imView)
            6 -> Picasso.get().load(ImagesUrl.filmEpVI).into(imView)
            7 -> Picasso.get().load(ImagesUrl.filmEpVII).into(imView)
            else -> Picasso.get().load(ImagesUrl.filmDefault).into(imView)
        }
    }
    @SuppressLint("SetTextI18n")
    private fun setText(){
        tvTitle.text = film.title
        tvDirector.text = "Director: " + film.director
        tvProducer.text = "Productor: " + film.producer
        tvReleaseDate.text = "Estreno: " + film.release_date
        tvOpening.text = film.opening_crawl
    }

    /*interface OnFragmentInteractionListenerSettings {
        fun popFragment()
    }*/
}