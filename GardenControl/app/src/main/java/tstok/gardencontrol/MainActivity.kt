package tstok.gardencontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS



class MainActivity : AppCompatActivity() {
    val database = FirebaseDatabase.getInstance()
    val lastOnSeconds = database.getReference("lastOn_seconds")!!
    val lastOnMinutes = database.getReference("lastOn_minutes")!!
    val lastOnHours = database.getReference("lastOn_hours")!!
    val lastOnDays = database.getReference("lastOn_days")!!
    val lawn = database.getReference("lawn")!!

    var seconds = 0L
    var minutes = 0L
    var hours = 0L
    var days = 0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lawn.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {
                lawnSwitch.isSelected = p0?.value as Boolean? ?: false
            }

            override fun onCancelled(p0: DatabaseError?) {
                Log.d("lawn", p0.toString())
            }
            }
        )

        lastOnSeconds.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {
                seconds = p0?.value as Long? ?: 0
                updateTime()
            }

            override fun onCancelled(p0: DatabaseError?) {
                Log.d("seconds", p0.toString())
            }
        }
        )

        lastOnMinutes.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {
                minutes = p0?.value as Long? ?: 0
                updateTime()
            }

            override fun onCancelled(p0: DatabaseError?) {
                Log.d("minutes", p0.toString())
            }
        }
        )

        lastOnHours.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {
                hours = p0?.value as Long? ?: 0
                updateTime()
            }

            override fun onCancelled(p0: DatabaseError?) {
                Log.d("hours", p0.toString())
            }
        }
        )

        lastOnDays.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {
                days = p0?.value as Long? ?: 0
                updateTime()
            }

            override fun onCancelled(p0: DatabaseError?) {
                Log.d("minutes", p0.toString())
            }
        }
        )

        lawnSwitch.setOnCheckedChangeListener { _, isChecked -> lawn.setValue(isChecked) }
    }

    fun updateTime() {
        if (seconds >= 60) {
            val d = TimeUnit.SECONDS.toDays(seconds)
            val h = TimeUnit.SECONDS.toHours(seconds) - d * 24
            val m = TimeUnit.SECONDS.toMinutes(seconds) - TimeUnit.SECONDS.toHours(seconds) * 60
            val s = TimeUnit.SECONDS.toSeconds(seconds) - TimeUnit.SECONDS.toMinutes(seconds) * 60

            time.text = "$d:$h:$m:$s "
        } else {
            time.text = "$days:$hours:$minutes:$seconds "
        }
    }
}
