package hr.algebra.mvpdagger.root

import android.app.Application
import hr.algebra.mvpdagger.module.LoginModule

class App : Application( ) {
    var component : ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate( )
        component = DaggerApplicationComponent
                                .builder( )
                                .loginModule( LoginModule( ) )
                                .build( )
    }
}