package com.utcc.sqlite

class User {

    var id: Int = 0
    var name: String? = null
    var age: Int = 0
    var gender: String? = null
    // constructor(id: In
    // t, userName: String) {
    constructor(id: Int, name: String, age: Int,gender: String) {
        this.id = id
        this.name = name
        this.age = age
        this.gender = gender
    }
    constructor(name: String, age: Int,gender: String) {
        this.name = name
        this.age = age
        this.gender = gender
    }

}

