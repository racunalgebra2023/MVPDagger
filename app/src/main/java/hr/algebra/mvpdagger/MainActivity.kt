package hr.algebra.mvpdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hr.algebra.mvpdagger.databinding.ActivityMainBinding
import hr.algebra.mvpdagger.root.App
import javax.inject.Inject

class MainActivity : AppCompatActivity( ), MainMVP.View {

    private lateinit var binding   : ActivityMainBinding

    @Inject
    lateinit var presenter : MainMVP.Presenter

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )

//      presenter = LoginPresenter( this )
        ( application as App ).component?.inject( this )


        binding.bSignIn.setOnClickListener {
            val firstName = binding.etFirstName.text.toString( ).trim( )
            val lastName  = binding.etLastName.text.toString( ).trim( )
            presenter.signInUser( firstName, lastName )
        }

        binding.bShowCurrentUser.setOnClickListener {
            presenter.showCurrentUser( )
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.view( this )
    }

    override fun update( firstName: String, lastName: String ) {
        binding.etFirstName.setText( firstName )
        binding.etLastName.setText( lastName )
    }

    override fun showSuccessMessage( ) {
        Toast
            .makeText( this, "User successfully saved", Toast.LENGTH_SHORT )
            .show( )
    }

    override fun showErrorMessage( ) {
        Toast
            .makeText( this, "Error while saving user", Toast.LENGTH_SHORT )
            .show( )
    }

    override fun showFirstNameEmptyError( ) {
        binding.etFirstName.error = "First name must not be Empty"
    }

    override fun showLastNameEmptyError( ) {
        binding.etLastName.error = "Last name must not be Empty"
    }
}