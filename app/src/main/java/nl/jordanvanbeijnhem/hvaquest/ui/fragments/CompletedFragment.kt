package nl.jordanvanbeijnhem.hvaquest.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_completed.*
import nl.jordanvanbeijnhem.hvaquest.R
import nl.jordanvanbeijnhem.hvaquest.ui.viewmodels.QuestionsViewModel

class CompletedFragment : Fragment() {

    private lateinit var viewModel: QuestionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity!!.toolbar.title = getString(R.string.quest_completed)
        viewModel =
            ViewModelProviders.of(activity as AppCompatActivity).get(QuestionsViewModel::class.java)

        return inflater.inflate(R.layout.fragment_completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnEnd.setOnClickListener {
            viewModel.reset()
            findNavController().navigate(R.id.action_completedFragment_to_homeFragment)
        }
    }
}
