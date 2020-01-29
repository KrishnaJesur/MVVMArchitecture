package com.krishna.kotlinlist.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.annotation.NonNull
import com.google.gson.Gson

@Suppress("unused", "deprecation")
object Preferences {
    private const val PREFERENCE_NAME = "APP_DATA"
    private const val KEY_ACCESS_TOKEN = "ACCESS_TOKEN"
    private const val KEY_LOCAL = "LOCAL"
    private const val KEY_TRAVEL_MODE = "travel_mode"
    private const val KEY_SESSION = "SESSION"
    private const val KEY_PARENT_DATA = "PARENT_DATA"
    private const val KEY_SCHOOL_LAT = "school_lat"
    private const val KEY_SCHOOL_LNG = "school_lng"

    fun saveSession(context: Context, session: Boolean) {
        context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit()
            .putBoolean(KEY_SESSION, session).apply()
    }

    @NonNull
    fun loadSession(context: Context): Boolean {
        return context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
            .getBoolean(KEY_SESSION, false)
    }

    fun saveAccessToken(context: Context, @NonNull token: String?) {
        context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit()
            .putString(KEY_ACCESS_TOKEN, token).apply()
    }

    @NonNull
    fun loadAccessToken(context: Context): String {

//        return  "bearer mLdeWwyd9I1-PsHL-N6sn66O9J-uviURtwvP2cz5p2f64wO1WcV3rpeaBhdJAlHY1FnsnnwHeIsR8RLeits2Biskmuu-1YmqLxhFkMNMQ__Ti51Ub_A-HM0xWRPtNyQZhyNLyw9KWjT7MQmt0tct4ihymI1-WaiXohHPP3w92mR-1qxq0a2eI0Pc8cacCEqMlDZ5LTY_WzwYtbTmLAR7NIm3UCLN5xFSudy3GXjjqfiac7o7a7o-d4BtKbsXBSgEClPJ2Tt_acNaI-G-Xzf-3qhgnKZOOpcmvAebTbve_EthQVEZAXsW9XyG0FAQUYwsOjKtlW6AlbfApngvt0O9l8RBQt3XZQj_89nWCHa8h3lTmhMtmBQ082q_iaitLGt8OD6J22nMQAlhgSwLz-Kn55o_-zUEyp5-sUiKrCaqA4LMSbUcTpBa1Z6hynKpjOem1v0hGoni6IaEpChxdi4Bbg"
        return  "bearer A857kEQNbcRz_eXoOgst8A7GeXYPs_7rrZvBh7xIQc90sJDSrBA--PsIrgYMt2FdXJU6bcMQby1p7tV5S8d-C7bY8HkXA4oq9os1fHIYNFHEL_ofLMYlCw8QmU5PK0E9LG6TOy9wc3ZzTAONPcPQCFxc8zJjh6yzcD-1-zAdI6UxFiWD3SyKAR_qrmOxGu-tFvMhk7LU9SzGmzh6E3Ih-o5hhe2ivyQs5gclNvcWMWX9d6cD256iFHc9r4ioawFfBat_XO-z5xX2SsHG55q4arP9rVuv7MTZToB0eG9xC_5s_zlcZxN-SqUhhuZetPENB0zH1nzH5LWSdQLuiQrAfVfcR3efZ5W_NeEeXaRW-TdfSwRdUTrswrOVosv7Ro_1WArs8VgsgRsfZptH05f4cfwKybUOGvPUdW6SoLjHW5BV3F-ZLuXosxJwOgwwzXbvKcf2YqyQu9r7gsBJR2lYzbA20pc"
//        return context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
//            .getString(KEY_ACCESS_TOKEN, "")!!
    }


    /**
     * Save parent data from login
     * */
//    fun saveParentData(context: Context, loginResModel: LoginResModel) {
//        val parentData = Gson().toJson(loginResModel)
//        context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit()
//            .putString(KEY_PARENT_DATA, parentData).apply()
//    }

    /**
     * Save parent data from get parent profile data
     * */
//    fun saveParentData(context: ParentProfileActivity, loginResModel: ParentProfileResModel) {
//        val parentData = Gson().toJson(loginResModel)
//        context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit()
//            .putString(KEY_PARENT_DATA, parentData).apply()
//    }
//
//    @NonNull
//    fun loadParentData(context: Context): LoginResModel {
//        return Gson().fromJson(
//            context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
//                .getString(KEY_PARENT_DATA, ""), LoginResModel::class.java
//        )
//    }

    fun saveLocale(context: Context, @NonNull localCode: String) {
        context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit()
            .putString(KEY_LOCAL, localCode).apply()
    }

    @NonNull
    fun loadLocale(context: Context): String {
        return context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
            .getString(KEY_LOCAL, "en")!!
    }

    /**
     * Clear the saved shared preference data on logout
     * */
    fun clearPreference(context: Context) {
        context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit().clear().apply()
    }
}