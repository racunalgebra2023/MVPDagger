package hr.algebra.mvpdagger.model

interface LoginRepository {
    fun getUser( ) : User
    fun saveUser( user: User )
}