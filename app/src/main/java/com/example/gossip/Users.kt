package com.example.gossip

class Users {

    var uid : String? = null
    var username : String? =null

    constructor(){

    }

    constructor(uid: String?, username: String?) {
        this.uid = uid
        this.username = username
    }

}