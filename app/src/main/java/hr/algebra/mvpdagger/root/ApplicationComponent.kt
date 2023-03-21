package hr.algebra.mvpdagger.root

import dagger.Component
import hr.algebra.mvpdagger.MainActivity
import hr.algebra.mvpdagger.module.LoginModule

@Component(modules=[LoginModule::class])
interface ApplicationComponent {
    fun inject( target: MainActivity )
}