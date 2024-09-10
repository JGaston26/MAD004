fun main() {
    println(wordList("ha", 3))
}
fun wordList(word: String, count: Int): MutableList<String>{
    val mutableList: MutableList<String> = mutableListOf()
    for(i in 0..<count){
        mutableList.add(word)
    }
    return mutableList
}