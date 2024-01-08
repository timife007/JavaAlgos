package algoexpert

fun shortenPath(path: String): String {
    var startsWithSlash = path[0] == '/'
    val list = path.split("/")
    val filtered = list.filter {
        it.isNotEmpty() && it != "."
    }
    val stack : ArrayDeque<String> = ArrayDeque()
    if(startsWithSlash){
        stack.addFirst("")
    }
    for(token in filtered){
        if(token == ".."){
            if(stack.isEmpty() || stack.last() == ".."){
                stack.addLast(token)
            }else if (stack.last() != ""){
                stack.removeLast()
            }
        }else{
            stack.addLast(token)
        }
    }
    if(stack.size == 1 && stack[0] == ""){
        return "/"
    }
    return stack.toArray().joinToString("/")
}


fun main() {
    val input = "../../../this////one/./../../is/../../going/../../to/be/./././../../../just/eight/double/dots/../../../../../../foo"
    println(shortenPath(input))
}