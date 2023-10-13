package www.uzmd.mybrodcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

class MyBrodcast:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(isNetwork(context)){
            //bu joyda biror bir ish bajariladi
            Log.e("TAG", "Internet ulangan", )
        }else{
            // aks holda bajariladi
            Log.e("TAG", "Internet ajratilgan", )
        }
    }
fun isNetwork(context: Context?): Boolean {
    val connectivityManager =
        context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager //connective manager olinadi
    val activeNetwork = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) //activ bo`lmasa null qiymat qabul qiladi
    return networkCapabilities !=null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)// Internet uchun shunday code
}
}