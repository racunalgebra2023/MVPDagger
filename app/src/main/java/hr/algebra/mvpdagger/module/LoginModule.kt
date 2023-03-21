package hr.algebra.mvpdagger.module

import dagger.Module
import dagger.Provides
import hr.algebra.mvpdagger.MainActivity
import hr.algebra.mvpdagger.MainMVP
import hr.algebra.mvpdagger.model.InMemoryRepository
import hr.algebra.mvpdagger.model.LoginModel
import hr.algebra.mvpdagger.model.LoginRepository
import hr.algebra.mvpdagger.presenter.LoginPresenter

@Module
class LoginModule {

    @Provides
    fun providePresenter( model : MainMVP.Model ) : MainMVP.Presenter {
        return LoginPresenter( model )
    }

    @Provides
    fun provideLoginRepository( ) : LoginRepository {
        return InMemoryRepository( )
    }

    @Provides
    fun provideModel( repository : LoginRepository ) : MainMVP.Model {
        return LoginModel( repository )
    }
/*
    @Provides
    fun provideView( activity : MainActivity ) : MainMVP.View {
        return activity
    }

    @Provides
    fun provideActivity( ) : MainActivity {
        return activity
    }
*/
}