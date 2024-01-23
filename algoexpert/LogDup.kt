package algoexpert

import java.lang.StringBuilder

fun logDump(): String {
    return "name=John Trust, username=john3, email=john3@gmail.com, id=434453; name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; name=Robert M, username=rm44, id=222342, email=rm@me.com; name=Robert M, username=rm4411, id=5535, email=rm@me.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"
}

fun main() {
    //split longDump into a list
    val list = logDump().split(";")
    //New List with split inner string
    val nestedList = mutableListOf<MutableList<String>>()
    val listWithUniqueUsernames = mutableListOf<MutableList<String>>()
    val resultingList = mutableListOf<String>()
    list.forEach {
        nestedList.add(it.split(",").toMutableList())
    }
    //Set to keep unique usernames
    val set = hashSetOf<String>()

    //Remove duplicate usernames
    nestedList.forEach { strings ->
        val username = strings.find {
            it.contains("username")
        }
        //If set already contains a username, continue the forEach loop else, add to the unique list
        if (!set.contains(username)) {
            if (username != null) {
                set.add(username)
            }
            listWithUniqueUsernames.add(strings)
        }
    }

    //To remove id of each item from the unique list
    listWithUniqueUsernames.forEach { strings ->
        strings.removeIf {
            it.contains("id")
        }
    }
    //join all inner items in the unique list with comma into the resulting list
    for (item in listWithUniqueUsernames) {
        resultingList.add(item.joinToString(","))
    }
    //join all
    println(resultingList.joinToString(";"))
}