package com.mtw.juancarlos.roomwordsample.helpers

import android.os.AsyncTask

class doAsync(var handler: ()->Unit) : AsyncTask<Void,Void,Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        handler()
        return null
    }

}