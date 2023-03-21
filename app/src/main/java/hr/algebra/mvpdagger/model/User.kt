package hr.algebra.mvpdagger.model

class User( val firstName : String, val lastName : String ) {
    private var id : Int = 0

    fun setId( id : Int ) {
        this.id = id
    }
}