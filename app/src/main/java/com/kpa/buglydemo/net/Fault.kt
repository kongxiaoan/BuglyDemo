package com.kpa.buglydemo.net

import android.net.sip.SipErrorCode
import java.lang.Exception

/**
 *author: mr.kong
 *Date:2018/10/31
 *description:
 *project name:BuglyDemo
 **/
class Fault : Exception {
    private var errorCode = 0

    constructor(errorCode: Int, message: String?) : super(message) {
        this.errorCode = errorCode
    }
}