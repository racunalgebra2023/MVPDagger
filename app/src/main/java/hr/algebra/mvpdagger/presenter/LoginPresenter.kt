package hr.algebra.mvpdagger.presenter

import hr.algebra.mvpdagger.MainMVP

class LoginPresenter( var model : MainMVP.Model? ) : MainMVP.Presenter {

    var view : MainMVP.View? = null

    override fun signInUser( firstName: String, lastName: String ) {
        if( firstName.isEmpty() )
            view?.showFirstNameEmptyError( )
        if( lastName.isEmpty() )
            view?.showLastNameEmptyError( )
        if( !( firstName.isEmpty( )&&lastName.isEmpty( ) ) ) {
            model?.createUser( firstName, lastName )
            val user = model?.getCurrentUser( )
            if( user!=null ) {
                view?.update( "", "" )
                view?.showSuccessMessage( )
            } else
                view?.showErrorMessage( )
        }
    }

    override fun showCurrentUser( ) {
        val user = model?.getCurrentUser( )
        user?.let { view?.update( it.firstName, it.lastName ) }
    }

    override fun view( view : MainMVP.View ) {
        this.view = view
    }
}