package hr.algebra.mvpdagger

import hr.algebra.mvpdagger.model.User

interface MainMVP {

    interface View {
        fun update( firstName : String, lastName : String )
        fun showSuccessMessage( )
        fun showErrorMessage( )
        fun showFirstNameEmptyError( )
        fun showLastNameEmptyError( )
    }

    interface Presenter {
        fun signInUser( firstName : String, lastName : String )
        fun showCurrentUser( )
        fun view( view : View )
    }

    interface Model {
        fun createUser( firstName : String, lastName : String )
        fun getCurrentUser( ) : User
    }
}