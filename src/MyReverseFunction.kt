import java.util.Scanner

fun main(args: Array<String>) {

    val listForReverse = mutableListOf<Any>("yagmur", "karaman", 117, "ibtech", "android", "bootcamp", 2021)
    println("###################################################################################")
    println("The list before reverse: $listForReverse")
    println()

    print("-> Enter the index to start with : ")
    val arrayIndex = Scanner(System.`in`)

    if (arrayIndex.hasNextInt()) {
        val startIndex = arrayIndex.nextInt()
        if(startIndex >= listForReverse.size || startIndex < 0) { // if index is not exist in array, print warning
            println("The index is not valid!!")
        }
        else if(startIndex == listForReverse.size - 1) { // if index is last of array, need no change
            println("\nThe list after reverse: " + listForReverse)
        }
        else {
            println("\nThe list after reverse: " + listForReverse.myReverse(startIndex))
        }
    }
    else { // if input type not integer
        println("The index is not valid!!")
    }
    println("###################################################################################")
}

fun MutableList<Any>.myReverse(startIndex: Int = 0): MutableList<Any> {

    val subListNotReversed = this.subList(0, startIndex) // no change part
    val subListForReversed = this.subList(startIndex, this.size) // the part to change
    val reversedSubList = subListForReversed.toMutableList() // the temp list of changing part
    var subListLastIndex = subListForReversed.size - 1 // the last index of changing part (end of list)

    // this loop iterates changing part of list from end and
    // sets new value to index until the beginning of part
    for(item in subListForReversed) {
        reversedSubList[subListLastIndex] = item
        subListLastIndex -= 1
    }
    // end of this, add reversed part to unchanging part, and get the result list
    subListNotReversed.addAll(reversedSubList)

    return subListNotReversed
}