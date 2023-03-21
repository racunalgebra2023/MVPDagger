package hr.algebra.mvpdagger.model

class InMemoryRepository : LoginRepository {
    private var user : User? = null

    override fun getUser( ): User {
        if( user==null ) {
            val userx = User( "Fox", "Mulder" )
            userx.setId( 1 )
            return userx
        }
        return user as User
    }

    override fun saveUser(user: User) {
        this.user = user
    }
}