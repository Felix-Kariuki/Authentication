package com.flexcode.authenticationapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.flexcode.authenticationapp.data.local.AuthPreferences
import com.flexcode.authenticationapp.data.remote.ApiService
import com.flexcode.authenticationapp.data.repository.AuthRepositoryImpl
import com.flexcode.authenticationapp.domain.repository.AuthRepository
import com.flexcode.authenticationapp.domain.use_case.LoginUseCase
import com.flexcode.authenticationapp.domain.use_case.RegisterUseCase
import com.flexcode.authenticationapp.util.Constants.AUTH_PREFERENCES
import com.flexcode.authenticationapp.util.Constants.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context) : DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(AUTH_PREFERENCES)
            }
        )

    @Provides
    @Singleton
    fun provideAuthPreferences(dataStore: DataStore<Preferences>) =
        AuthPreferences(dataStore)


    @Provides
    @Singleton
    fun providesApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesAuthRepository(
        apiService: ApiService,
        preferences: AuthPreferences
    ): AuthRepository {
        return AuthRepositoryImpl(
            apiService = apiService,
            preferences = preferences
        )
    }

    @Provides
    @Singleton
    fun providesLoginUseCase(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }


    @Provides
    @Singleton
    fun providesRegisterUseCase(repository: AuthRepository): RegisterUseCase {
        return RegisterUseCase(repository)
    }

}