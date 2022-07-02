package com.cesor.android.snapshots.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cesor.android.snapshots.R
import com.cesor.android.snapshots.SnapshotsApplication
import com.cesor.android.snapshots.databinding.FragmentProfileBinding
import com.cesor.android.snapshots.utils.FragmentAux
import com.firebase.ui.auth.AuthUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment(), FragmentAux {
    private lateinit var mBinding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refresh()
        setupButton()
        mBinding.tvName.text = FirebaseAuth.getInstance().currentUser?.displayName
        mBinding.tvEmail.text = FirebaseAuth.getInstance().currentUser?.email
        mBinding.btnLogout.setOnClickListener { signOut() }
    }

    private fun setupButton() {
        mBinding.btnLogout.setOnClickListener {
            context?.let {
                MaterialAlertDialogBuilder(it)
                    .setTitle(R.string.dialog_logout_title)
                    .setPositiveButton(R.string.dialog_logout_confirm) { _, _ ->
                        signOut()
                    }

                    .setNegativeButton(R.string.dialog_logout_cancel, null)
                    .show()
            }
        }
    }


    private fun signOut() {
        context?.let {
            AuthUI.getInstance().signOut(it)
                .addOnCompleteListener {
                    Toast.makeText(context, R.string.profile_logout_success, Toast.LENGTH_SHORT).show()
                    (activity?.findViewById(R.id.bottomNavMenu) as? BottomNavigationView)?.selectedItemId =
                        R.id.action_home
                }
        }
    }

    /*
    * FragmentAux
    * */
    override fun refresh() {
        with(mBinding) {
            tvName.text = SnapshotsApplication.currentUser.displayName
            tvEmail.text = SnapshotsApplication.currentUser.email
        }
    }
}