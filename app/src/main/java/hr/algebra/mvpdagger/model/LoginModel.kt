package hr.algebra.mvpdagger.model

import hr.algebra.mvpdagger.MainMVP

class LoginModel( private val loginRepository : LoginRepository ) : MainMVP.Model {
    override fun createUser( firstName: String, lastName: String ) {
        loginRepository.saveUser( User( firstName, lastName ) )
    }

    override fun getCurrentUser( ): User {
        return loginRepository.getUser( )
    }
}