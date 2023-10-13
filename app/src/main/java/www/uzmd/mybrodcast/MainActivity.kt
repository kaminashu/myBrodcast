package www.uzmd.mybrodcast

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var myBrodcast:MyBrodcast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Broad cast receiverdan obeykt olinadi
         myBrodcast=MyBrodcast()
        val intentFilter=IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(myBrodcast,intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBrodcast)
    }
}