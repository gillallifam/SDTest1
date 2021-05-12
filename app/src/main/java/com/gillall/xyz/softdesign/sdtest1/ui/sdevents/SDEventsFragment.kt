package com.gillall.xyz.softdesign.sdtest1.ui.sdevents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gillall.xyz.softdesign.sdtest1.R
import com.gillall.xyz.softdesign.sdtest1.databinding.SdeventsFragmentBinding
import com.gillall.xyz.softdesign.sdtest1.util.Dialog
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import kotlinx.android.synthetic.main.dialog_location.*
import org.koin.androidx.viewmodel.ext.android.getViewModel


class SDEventsFragment : Fragment() {

    private lateinit var binding: SdeventsFragmentBinding
    private lateinit var navController: NavController
    private lateinit var viewModel: SDEventsViewModel
    private lateinit var sDEventsAdapter: SDEventsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getViewModel()
        binding = DataBindingUtil.inflate(inflater, R.layout.sdevents_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        navController = findNavController(this)

        setupSDEvents()
        return binding.root
    }

    /**
     * The fragment handle the click on adapter item
     * The model and the view are passed to listener
     * That way the listener can differentiate the click in diferent views by tag or type
     */
    private fun setupSDEvents() {
        sDEventsAdapter = SDEventsAdapter(SDEventClickListener { sdevent, view ->
            val bundle = Bundle()
            bundle.putString("eventId", sdevent.id)
            navController.navigate(R.id.action_mainFragment_to_eventViewer, bundle)
        })
        binding.recycleSDEvents.adapter = sDEventsAdapter
        binding.recycleSDEvents.layoutManager =
            GridLayoutManager(activity, 1, GridLayoutManager.VERTICAL, false)
        viewModel.events.observe(viewLifecycleOwner, {
            sDEventsAdapter.submitList(it)
        })
        viewModel.getEvents()
        //testMap()
    }

    private fun testMap() {//try to use map
        val dialogLocation =
            context?.let { Dialog.dialogCreate(it, R.layout.dialog_location, false) }
        dialogLocation?.show()
        val map = dialogLocation?.findViewById<MapView>(R.id.mapView)
        map?.getMapAsync {
            println(it)
        }
        with(mapView) {
            println(this)
            // Initialise the MapView
            onCreate(null)
            // Set the map ready callback to receive the GoogleMap object
            getMapAsync {
                MapsInitializer.initialize(context)
            }
        }
        //context?.let { Dialog.dialogCreate(it,R.layout.dialog_location,false).show() }
    }
}