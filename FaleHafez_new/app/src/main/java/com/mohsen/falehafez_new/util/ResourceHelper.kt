package com.mohsen.falehafez_new.util

import android.content.Context
import android.content.Intent
import com.mohsen.falehafez_new.R

class ResourceHelper private constructor(context: Context) {

    //private val questionList = mutableListOf<IQQuestion>()
    private lateinit var randomPoem : String
    private lateinit var poem:List<String>


    companion object {
        private var instance: ResourceHelper? = null

        fun getInstance(context: Context): ResourceHelper {
            if (instance == null)
                instance = ResourceHelper(context)

            return instance as ResourceHelper
        }
    }

    init {
        //getData(context)
        getPoemData(context)
    }

    fun getPoemData(context: Context){
        val poemArray=context.resources.getStringArray(R.array.hafez)
        val rnd = (0..494).random()
        randomPoem= poemArray[rnd]
    }

    fun getPoems():List<String>{
        val poems = randomPoem.substring(0,randomPoem.indexOf("n"))
        poem=poems.split("m")
        return poem
    }

    fun getEvaluate():String{
        return randomPoem.substring(randomPoem.lastIndexOf("n") + 1)
    }

//    fun getSharePoemsIntent(): Intent {
//        val poemItems=poem
//        var message = "فال حافط \n\n"
//        for (i in 0 until poemItems.size) {
//            message += if (i % 2 == 0)
//                poemItems[i] + "\n"
//            else
//                "\t\t\t\t\t" + poemItems[i]+"\n\n"
//        }
//        message+="تفسیر فال\n"
//        message+=randomPoem.substring(randomPoem.lastIndexOf("n") + 1)+"\n"
//        message+="\n برای دریافت اپلیکیشن هشدار از لینک زیر استفاده کنید"
//        message+="\n$APP_ADDRESS"
//        return Intent().apply {
//            action = Intent.ACTION_SEND
//            putExtra(Intent.EXTRA_TEXT, message)
//            type = "text/plain"
//        }
//    }
}